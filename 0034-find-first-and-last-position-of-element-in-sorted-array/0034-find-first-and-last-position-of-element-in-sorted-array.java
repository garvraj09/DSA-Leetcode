class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int lb = lowerBound(nums, n, target);

        if(lb == n || nums[lb] != target){
            return new int[]{-1, -1};
        }

        return new int[]{lb, upperBound(nums, n, target) - 1};
    }

    private int lowerBound(int[] nums, int n, int target) {
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

    private int upperBound(int[] nums, int n, int target) {
        int ans = n;
        int l =0, h = n -1;

        while(l <= h){
            int mid = (l+h)/2;

            if(nums[mid] > target){
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