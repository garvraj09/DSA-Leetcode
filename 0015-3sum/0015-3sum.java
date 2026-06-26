class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;

        //Brute force approach:
        /*Set<List<Integer>> set = new HashSet<>();

        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                for(int k = j+1; k < n; k++){
                    if(nums[i] + nums[j] + nums[k] == 0){
                        List<Integer> list = Arrays.asList(nums[i],nums[j],nums[k]);
                        Collections.sort(list);
                        set.add(list);
                    }
                }
            }
        }

        return new ArrayList<>(set);*/


        //Better appraoch:

        /*Set<List<Integer>> res = new HashSet<>();
        
        for(int i = 0; i < n; i++){
            Set<Integer> set = new HashSet<>();

            for(int j = i+1; j < n; j++){
                int three = -(nums[i] + nums[j]);

                if(set.contains(three)){
                    List<Integer> list = Arrays.asList(nums[i],nums[j],three);
                    Collections.sort(list);
                    res.add(list);
                }

                set.add(nums[j]);
            }
        }
        return new ArrayList<>(res);*/


        //Optimal approach:

        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0; i< n - 2; i++){
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }

            int l = i + 1, r = n-1;
            while(l < r){
                int sum = nums[i]+nums[l]+nums[r];

                if(sum == 0){
                    ans.add(Arrays.asList(nums[i],nums[l],nums[r]));

                    l++;
                    r--;
                
                    while(l < r && nums[l] == nums[l-1]){
                        l++;
                    }
                    while(l < r && nums[r] == nums[r+1]){
                        r--;
                    }
                }else if(sum < 0){
                    l++;
                }else{
                    r--;
                }
            }
        }
        return ans;
    }
}