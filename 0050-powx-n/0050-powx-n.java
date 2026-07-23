class Solution {
    public double myPow(double x, int n) {
        if(n == 1) return x;
        if(x == 1) return x;
        if(n == 0) return 1.0;

        long bin = n;
        if(bin < 0){
            x = 1/x;
            bin = -bin;
        }

        double res = 1.0;

        while(bin != 0){
            if(bin % 2 == 1){
                res *= x;
            }
            x *= x;
            bin /= 2;
        }
        return res;
    }
}