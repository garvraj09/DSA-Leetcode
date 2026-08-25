class Solution {
    public int missingMultiple(int[] nums, int k) {
        int n = nums.length;
        int ans = k;

        Set<Integer> set = new HashSet<>();

        for(int a: nums){
            set.add(a);
        }

        int i = 1;
        while(i < Integer.MAX_VALUE){
            if(set.contains(k * i)){
                i++;
            }
            else{
                ans = k * i;
                break;
            }
        }
        return ans;
    }
}