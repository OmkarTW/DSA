class Solution {
    public int maxPalindromes(String s, int k) {

        int n = s.length();

        // pal[i][j] = true if s[i...j] is a palindrome
        boolean[][] pal = new boolean[n][n];

        // Build palindrome table
        for (int i = n - 1; i >= 0; i--) {

            for (int j = i; j < n; j++) {

                // Characters at both ends must match
                // and the inside must also be a palindrome
                if (s.charAt(i) == s.charAt(j)
                        && (j - i <= 2 || pal[i + 1][j - 1])) {

                    pal[i][j] = true;
                }
            }
        }

        /*
         * dp[i] = maximum number of valid palindromes
         * that can be selected from s[0...i-1].
         */
        int[] dp = new int[n + 1];

        for (int i = 0; i < n; i++) {

            // Option 1: Don't choose a palindrome ending at i
            dp[i + 1] = dp[i];

            /*
             * Try every substring ending at i.
             *
             * j = starting position
             */
            for (int j = 0; j <= i; j++) {

                int length = i - j + 1;

                // We need length >= k
                if (length >= k && pal[j][i]) {

                    /*
                     * s[j...i] is a valid palindrome.
                     *
                     * dp[j] contains the best answer
                     * before this palindrome starts.
                     *
                     * Therefore we can safely add 1.
                     */
                    dp[i + 1] = Math.max(
                        dp[i + 1],
                        dp[j] + 1
                    );
                }
            }
        }

        return dp[n];
    }
}