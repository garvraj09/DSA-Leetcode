class Solution {
    public int minOperations(int[] a, int x) {
        int n = a.length;

        int total = 0;
        for(int i: a){
            total += i;
        }

        int target = total - x;

        if(target == 0){
            return n;
        }

        if(target < 0){
            return -1;
        }

        int l = 0;
        int sum = 0;
        int maxLen = -1;

        for(int r = 0; r < n ; r++){
            sum += a[r];

            while(sum > target && l <= r){
                sum -= a[l];
                l++;
            }

            if(sum == target){
                maxLen = Math.max(maxLen, r - l + 1);
            }
        }

        return maxLen == -1 ? -1 : n - maxLen;
    }
}