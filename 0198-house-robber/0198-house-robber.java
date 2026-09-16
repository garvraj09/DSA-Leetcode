class Solution {
    public int rob(int[] a) {
        int n = a.length;

        if(n == 1){
            return a[0];
        }

        int prev2 = 0;
        int prev1= 0;

        for(int i = 0; i < n;i++){
            int rob = a[i] + prev2;

            int skip = prev1;

            int curr = Math.max(rob, skip);

            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}