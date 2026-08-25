class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int l = 1;
        int r = max(piles, n);
        int ans = Integer.MAX_VALUE;
        while(l <= r){
            int m = l + (r - l)/2;
            if(calcTotalhours(piles, h, m)){
                ans = Math.min(ans, m);
                r = m - 1;
            }else{
                l = m + 1;
            }
        }
        return ans;
    }

    private boolean calcTotalhours(int piles[], int h, int k){
        int n = piles.length;
        long hours = 0;
        for(int i = 0; i < n; i++){
            hours += (piles[i] + k - 1) / k;
        }

        return hours <= h;
    }

    private int max(int piles[], int n){
        int max = piles[0];
        for(int i =0 ; i < n; i++){
            max = Math.max(max, piles[i]);
        }
        return max;
    }
}