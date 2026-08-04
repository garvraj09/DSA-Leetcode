class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int nums[], int low, int high){
        int c = 0;
        if(low >= high) return 0;

        int mid = low + (high - low)/2;

        c += mergeSort(nums, low, mid);
        c += mergeSort(nums, mid+1, high);

        c += countPairs(nums, low, mid, high);

        merge(nums, low, mid, high);

        return c;
    }

    private void merge(int nums[], int low, int mid, int high){
        int left = low;
        int right = mid + 1;
        int k = 0;
        int temp[] = new int[high - low + 1];

        while(left <= mid && right <= high){
            if(nums[left] <= nums[right]){
                temp[k++] = nums[left++];
            }
            else{
                temp[k++] = nums[right++];
            }
        }

        while(left <= mid){
            temp[k++] = nums[left++];
        }

        while(right <= high){
            temp[k++] = nums[right++];
        }

        for(int i = 0; i < temp.length; i++){
            nums[low + i] = temp[i];
        }
    }

    private int countPairs(int nums[], int low, int mid, int high){
        int count = 0;
        int right = mid + 1;
        for(int i = low; i <= mid; i++){
            while(right <= high && (long) nums[i] > 2L * nums[right]){
                right++;
            }
            count += right - (mid + 1);
        }

        return count;
    }
}