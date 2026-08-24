class Solution {
    public int findMin(int[] a) {
        int n = a.length;
        int l = 0, h = n - 1;
        int ans = Integer.MAX_VALUE;
        while(l <= h){
            int mid = (l+h)/2;

            if(a[l] <= a[h]){
                ans = Math.min(ans, a[l]);
                break;
            }

            if(a[l] <= a[mid]){
                ans = Math.min(ans, a[l]);
                l = mid + 1;
            }

            else{
                ans = Math.min(ans, a[mid]);
                h = mid - 1;
            }
        }
        return ans;
    }
}