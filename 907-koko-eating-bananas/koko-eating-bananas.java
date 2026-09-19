class Solution {
    public int minEatingSpeed(int[] piles, int h) {
         // Initialize binary search bounds
        int low = 1, high = findMax(piles);

        // Apply binary search
        while (low <= high) {
            int mid = (low + high) / 2;
            long totalH = calculateTotalHours(piles, mid);
            if (totalH <= h) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    /* Helper function to find the
    maximum element in the array*/
    private int findMax(int[] nums) {
        int maxi = Integer.MIN_VALUE;
        int n = nums.length;

        // Find the maximum element
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, nums[i]);
        }
        return maxi;
    }

    /* Helper function to calculate total
    hours required at given hourly rate*/
    private long calculateTotalHours(int[] nums, int hourly) {
        long totalH = 0;
        int n = nums.length;

        // Calculate total hours required
        for (int i = 0; i < n; i++) {
            totalH += Math.ceil((double) nums[i] / (double) hourly);
        }
        return totalH;
    }
}