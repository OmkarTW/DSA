class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {

        int n = nums1.length;
        long k = (long) k1 + k2;

        int[] diff = new int[n];
        int maxDiff = 0;
        long total = 0;

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            maxDiff = Math.max(maxDiff, diff[i]);
            total += diff[i];
        }

        if (total <= k) return 0;

        int low = 0, high = maxDiff;

        // Find the smallest maximum difference achievable
        while (low < high) {
            int mid = low + (high - low) / 2;
            long needed = 0;

            for (int d : diff) {
                if (d > mid) {
                    needed += d - mid;
                }
            }

            if (needed <= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        // Reduce every difference above the chosen level
        long remaining = k;
        long ans = 0;

        for (int d : diff) {
            if (d > low) {
                remaining -= d - low;
                d = low;
            }
            ans += (long) d * d;
        }

        // Use leftover operations to reduce differences at the boundary
        // Each such operation reduces a difference of low to low - 1.
        if (low > 0) {
            long count = 0;
            for (int d : diff) {
                if (d >= low) count++;
            }

            long extra = Math.min(remaining, count);

            ans -= extra * (2L * low - 1);
        }

        return ans;
    }
}