class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int []res = new int[2];
        res[0] = firstocc(nums, target);
        res[1] = secondocc(nums, target);
        return res;
    }

    private int firstocc(int[] nums, int target){
        int left = 0, right = nums.length-1, mid, first = -1;

        while(left <= right){
            mid = left+(right-left)/2;

            if(nums[mid] == target){
                first = mid;
                right = mid-1;    // this one is different
            }
            else if(nums[mid] < target){
                left = mid+1;
            }
            else {
                right = mid-1;
            }
        }
        return first;
    }
        
    private int secondocc(int[] nums, int target){
        int left = 0, right = nums.length-1, mid, second = -1;

        while(left <= right){
            mid = left+(right-left)/2;

            if(nums[mid] == target){
                second = mid;
                left = mid+1;
            }
            else if(nums[mid] < target){
                left = mid+1;
            }
            else {
                right = mid-1;
            }
        }
        return second;
    }
}