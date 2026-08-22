class Solution {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int ans = n;
        int l =0, h = n -1;

        while(l <= h){
            int mid = (l+h)/2;

            if(nums[mid] >= target){
                ans = mid;
                h = mid - 1;
            }
            else{
                l = mid + 1;
            }
        }
        return ans;
    }
}