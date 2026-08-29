class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;

        // Store {value, originalIndex}.
        int[][] pairs = new int[n][2];

        for (int i = 0; i < n; i++) {
            pairs[i][0] = nums[i];
            pairs[i][1] = i;
        }

        // Sort by value.
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[0], b[0]));

        int[] result = new int[n];

        int start = 0;

        while (start < n) {
            int end = start;

            // Find one connected group.
            while (end + 1 < n &&
                   pairs[end + 1][0] - pairs[end][0] <= limit) {
                end++;
            }

            // Collect original indices of this group.
            int size = end - start + 1;
            int[] indices = new int[size];

            for (int i = 0; i < size; i++) {
                indices[i] = pairs[start + i][1];
            }

            // Smallest indices should receive smallest values.
            Arrays.sort(indices);

            for (int i = 0; i < size; i++) {
                result[indices[i]] = pairs[start + i][0];
            }

            start = end + 1;
        }

        return result;
    }
}