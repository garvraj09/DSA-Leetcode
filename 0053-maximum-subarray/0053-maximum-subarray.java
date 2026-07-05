class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int curr = 0;
        for(int n : nums){
            curr += n;
            if(curr > max){
                max = curr;
            }
            if(curr < 0){
                curr = 0;
            }
        }
        return max;
    }
}