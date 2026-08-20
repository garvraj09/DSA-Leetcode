class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {

        // another approach (prefix sum, hashmap) :-

        // HashMap<Integer, Integer> map = new HashMap<>();
        // map.put(0,1);

        // int sum = 0;
        // int count = 0;
        // for(int i = 0; i < nums.length; i++){
        //     sum += nums[i];

        //     if(map.containsKey(sum - goal)){
        //         count += map.get(sum - goal);
        //     }

        //     map.put(sum, map.getOrDefault(0, sum) + 1);
        // }
        // return count;
        

        return atMost(nums, goal) - atMost(nums, goal - 1);
    }

    private int atMost(int []nums, int goal){
        if(goal < 0){
            return 0;
        }

        int l = 0;
        int sum = 0;
        int count = 0;

        for(int r = 0; r < nums.length; r++){
            sum += nums[r];

            while(sum > goal){
                sum -= nums[l];
                l++;
            }

            count += (r - l + 1);
        }
        return count;
    }
}