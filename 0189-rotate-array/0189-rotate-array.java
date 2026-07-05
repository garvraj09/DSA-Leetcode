class Solution {
    public void rotate(int[] arr, int k) {
        // int n = nums.length;

        //BRUTE FORCE APPROACH

        // if (n==0)
        // return;
        // k = k % n;
        // if(k > n)
        // return;
        // int temp[] = new int[k];

        // //storing in temp arr
        // for(int i = 0; i < k ; i++){
        //     temp[i] = nums[i];
        // }

        // //shifting
        // for (int i = k ; i < n ; i++){
        //     nums[i-k] = nums[i];
        // }

        // // putting back temp
        // for(int i = n-k; i<n ;i++){
        //     nums[i]=temp[i-(n-k)];
        // }

        //OPTIMAL APPROACH

        int n = arr.length;
        k = k % n; // Handle cases where k > n

        // Reverse the entire array
        reverse(arr, 0, n - 1);
        // Reverse the first k elements
        reverse(arr, 0, k - 1);
        // Reverse the remaining elements
        reverse(arr, k, n - 1);
    }

    public static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}