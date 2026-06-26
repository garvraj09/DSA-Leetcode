class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> mpp = new HashMap<>();
        int n = nums.length;
        for(int i=0; i<n ; i++){
            int num = nums[i];
            int more = target - num;
            if(mpp.containsKey(more)){
                return new int[] { mpp.get(more), i};
            }
            mpp.put(nums[i],i);
        }
        return new int[] {-1,-1};
    }
}