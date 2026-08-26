class Solution {
    public int minDays(int[] a, int m, int k) {
        int n = a.length;
        if ((long) m * k > n) {
            return -1;
        }
        int l = min(a);
        int r = max(a);
        int ans = Integer.MAX_VALUE;

        while(l <= r){
            int mid = (l+r)/2;

            if(canBloom(a, mid, m, k)){
                ans = Math.min(ans, mid);
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return ans;
    }

    private boolean canBloom(int[] a, int mid, int m, int k) {

        int flower = 0;
        int bouquets = 0;

        for (int i = 0; i < a.length; i++) {

            if (a[i] <= mid) {

                flower++;

                if (flower == k) {
                    bouquets++;
                    flower = 0;
                }

            } else {
                flower = 0;
            }
        }

        return bouquets >= m;
    }

    private int max(int []a){
        int max = a[0];
        for(int i = 1; i< a.length; i++){
            max = Math.max(max, a[i]);
        }
        return max;
    }

    private int min(int []a){
        int min = a[0];
        for(int i = 1; i< a.length; i++){
            min = Math.min(min, a[i]);
        }
        return min;
    }
}