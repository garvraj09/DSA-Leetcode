class Solution {
    public int smallestDivisor(int[] a, int threshold) {
        int n = a.length;
        int l = 1;
        int r = max(a);
        int ans = Integer.MAX_VALUE;
        while(l <= r){
            int mid = (l + r)/2;
            if(findDivisor(a,mid, threshold)){
                ans = Math.min(ans, mid);
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return ans;
    }

    private boolean findDivisor(int a[], int mid, int threshold){
        int sum = 0;
        for(int i : a){
            int num = (i + mid - 1)/mid;
            sum += num;
        }

        return sum <= threshold;
    }

    private int max(int a[]){
        int max = a[0];
        for(int i = 0; i < a.length; i++){
            max = Math.max(max, a[i]);
        }
        return max;
    }
}