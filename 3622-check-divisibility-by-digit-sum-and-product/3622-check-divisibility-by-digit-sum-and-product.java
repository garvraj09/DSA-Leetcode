class Solution {
    public boolean checkDivisibility(int n) {
        int sum = 0;
        int product = 1;
        int m = n;
        while(m > 0){
            int r = m % 10;
            sum += r;
            product *= r;

            m = m / 10;
        }

        return (n % (sum + product)) == 0;
    }
}