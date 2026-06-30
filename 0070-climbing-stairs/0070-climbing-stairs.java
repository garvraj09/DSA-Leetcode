class Solution {
    public int climbStairs(int n) {
        if(n <= 2) return n;

        int fir = 1;
        int sec = 2;
        for(int i = 3; i <= n; i++){
            int curr = fir+sec;
            fir = sec;
            sec = curr;
        }
        return sec;
    }
}