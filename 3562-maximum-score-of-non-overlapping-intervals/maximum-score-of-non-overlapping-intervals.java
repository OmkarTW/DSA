import java.util.*;

class Solution {

    static class State {
        long score;
        List<Integer> indices;

        State(long score, List<Integer> indices) {
            this.score = score;
            this.indices = indices;
        }
    }

    public int[] maximumWeight(List<List<Integer>> intervals) {

        int n = intervals.size();

        int[][] a = new int[n][4];

        for (int i = 0; i < n; i++) {
            a[i][0] = intervals.get(i).get(0);
            a[i][1] = intervals.get(i).get(1);
            a[i][2] = intervals.get(i).get(2);
            a[i][3] = i;
        }

        Arrays.sort(a, (x, y) -> Integer.compare(x[0], y[0]));

        int[] next = new int[n];

        for (int i = 0; i < n; i++) {
            int low = i + 1;
            int high = n;

            while (low < high) {
                int mid = low + (high - low) / 2;

                if (a[mid][0] > a[i][1])
                    high = mid;
                else
                    low = mid + 1;
            }

            next[i] = low;
        }

        State[][] dp = new State[n + 1][5];

        // Base case: choosing 0 intervals
        for (int i = 0; i <= n; i++) {
            dp[i][0] = new State(0, new ArrayList<>());
        }

        // Base case: no intervals remaining
        for (int k = 0; k <= 4; k++) {
            dp[n][k] = new State(0, new ArrayList<>());
        }

        for (int i = n - 1; i >= 0; i--) {

            for (int k = 1; k <= 4; k++) {

                // Skip current interval
                State skip = dp[i + 1][k];

                // Take current interval
                State future = dp[next[i]][k - 1];

                List<Integer> takeIndices =
                        new ArrayList<>(future.indices);

                takeIndices.add(a[i][3]);

                Collections.sort(takeIndices);

                State take = new State(
                        a[i][2] + future.score,
                        takeIndices
                );

                dp[i][k] = better(take, skip);
            }
        }

        return dp[0][4].indices
                .stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    private State better(State a, State b) {

        if (a.score != b.score) {
            return a.score > b.score ? a : b;
        }

        return lexicographicallySmaller(a.indices, b.indices)
                ? a
                : b;
    }

    private boolean lexicographicallySmaller(
            List<Integer> a,
            List<Integer> b) {

        for (int i = 0; i < Math.min(a.size(), b.size()); i++) {

            if (!a.get(i).equals(b.get(i))) {
                return a.get(i) < b.get(i);
            }
        }

        return a.size() < b.size();
    }
}