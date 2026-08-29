class Solution {
    public int shipWithinDays(int[] a, int days) {
        int n = a.length;
        int l = max(a);
        int r = sum(a);
        int ans = Integer.MAX_VALUE;
        while(l <= r){
            int mid = (l + r)/2;
            if(daysReq(a, mid, days)){
                ans = Math.min(ans, mid);
                r = mid - 1;
            }
            else{
                l = mid + 1;
            }
        }
        return ans;
    }

    private boolean daysReq(int a[], int mid, int days){
        int day = 1;
        int load = 0;
        for(int i = 0; i < a.length; i++){
            if(load + a[i] > mid){
                day += 1;
                load = a[i];
            }
            else{
                load += a[i];
            }
        }

        return day <= days;
    }

    private int max(int a[]){
        int max = a[0];
        for(int i = 0; i < a.length; i++){
            max = Math.max(max, a[i]);
        }
        return max;
    }

    private int sum(int a[]){
        int sum = 0;
        for(int i = 0; i < a.length; i++){
            sum += a[i];
        }
        return sum;
    }
}