class Solution {
    public int numberOfSets(int n, int k) {

        int MOD = 1_000_000_007;

        // dp[i][j] = number of ways to draw j segments
        // using the first i points
        long[][] dp = new long[n + 1][k + 1];

        // With 0 segments, there is exactly 1 way:
        // choose nothing.
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        // Build answers for 1 to k segments
        for (int j = 1; j <= k; j++) {

            // prefix stores:
            // dp[1][j-1] + dp[2][j-1] + ... + dp[i-1][j-1]
            long prefix = 0;

            for (int i = 1; i <= n; i++) {

                // Add dp[i-1][j-1] to the running sum.
                // For i = 1, this is dp[0][j-1],
                // which should NOT be used because a segment
                // needs at least two points.
                if (i >= 2) {
                    prefix = (prefix + dp[i - 1][j - 1]) % MOD;
                }

                // Option 1:
                // Don't use point i-1 as the end of a new segment.
                dp[i][j] = dp[i - 1][j];

                // Option 2:
                // End a new segment at point i-1.
                //
                // prefix contains all possible ways to place
                // the previous j-1 segments.
                dp[i][j] = (dp[i][j] + prefix) % MOD;
            }
        }

        return (int) dp[n][k];
    }
}