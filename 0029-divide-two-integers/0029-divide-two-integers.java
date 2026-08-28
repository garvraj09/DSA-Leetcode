class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend == divisor) return 1;
        boolean sign = true;
        if(dividend >= 0 && divisor < 0)  sign = false;
        if(dividend < 0 && divisor > 0)  sign = false; 

        long ans = 0;
        long n = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);

        while(n >= d){
            int cnt = 0;
            while(n >= (d << (cnt + 1))){
                cnt++;
            }

            ans += (1L << cnt);
            n -= (d << cnt);
        }

        if(sign == false){
            ans = -ans;
        }

        if(ans > Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        if(ans < Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }

        return (int) ans;
    }
}