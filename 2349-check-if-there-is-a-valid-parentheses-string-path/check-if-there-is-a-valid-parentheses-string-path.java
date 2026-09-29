class Solution {
    public boolean hasValidPath(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        // Path length must be even
        if ((m + n - 1) % 2 == 1) {
            return false;
        }

        // Valid parentheses string must start with '('
        if (grid[0][0] != '(') {
            return false;
        }

        // Valid parentheses string must end with ')'
        if (grid[m - 1][n - 1] != ')') {
            return false;
        }

        // dp[i][j][balance]
        boolean[][][] dp = new boolean[m][n][m + n];

        // Starting cell '(' gives balance = 1
        dp[0][0][1] = true;

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                // Starting cell already handled
                if (i == 0 && j == 0) {
                    continue;
                }

                for (int balance = 0; balance < m + n; balance++) {

                    int prevBalance;

                    if (grid[i][j] == '(') {
                        prevBalance = balance - 1;
                    } else {
                        prevBalance = balance + 1;
                    }

                    if (prevBalance < 0 || prevBalance >= m + n) {
                        continue;
                    }

                    // Come from above
                    if (i > 0 && dp[i - 1][j][prevBalance]) {
                        dp[i][j][balance] = true;
                    }

                    // Come from left
                    if (j > 0 && dp[i][j - 1][prevBalance]) {
                        dp[i][j][balance] = true;
                    }
                }
            }
        }

        // At the end, balance MUST be 0
        return dp[m - 1][n - 1][0];
    }
}

