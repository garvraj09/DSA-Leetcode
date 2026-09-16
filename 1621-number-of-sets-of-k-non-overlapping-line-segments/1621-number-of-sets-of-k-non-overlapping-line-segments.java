class Solution {
    static final int MOD = 1_000_000_007;

    public int numberOfSets(int n, int k) {

        long[] dp = new long[n];

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        for (int segments = 1; segments <= k; segments++) {

            long[] next = new long[n];
            long sum = 0;

            for (int i = 1; i < n; i++) {

                sum = (sum + dp[i - 1]) % MOD;

                next[i] = (next[i - 1] + sum) % MOD;
            }

            dp = next;
        }

        return (int) dp[n - 1];
    }
}