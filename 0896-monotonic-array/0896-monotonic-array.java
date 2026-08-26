class Solution {
    public boolean isMonotonic(int[] nums) {
        int n = nums.length;
        int incre = 0;
        int decre = 0;
        for(int i =0; i<= n - 2; i++){
            if(nums[i] <= nums[i+1]){
                incre++;
            }
            if(nums[i] >= nums[i+1]){
                decre++;
            }
        }

        if(incre == n - 1 || decre == n - 1){
            return true;
        }
        return false;
    }
}