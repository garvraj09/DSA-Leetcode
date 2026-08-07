class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int left = 0, zeros = 0, maxlen = 0;

        for(int right = 0; right < n; right++){
            if(nums[right] == 0){
                zeros++;
            }

            while(zeros > k){
                if(nums[left] == 0){
                    zeros--;
                }
                left++;
            }
            maxlen = Math.max(maxlen, (right - left +1));
        }
        return maxlen;
    }
}