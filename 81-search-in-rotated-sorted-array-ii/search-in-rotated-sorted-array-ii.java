class Solution {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        int low = 0, high = n - 1;
        
        // Applying binary search algorithm 
        while (low <= high) {
            int mid = (low + high) / 2;

            // Check if mid points to target
            if (nums[mid] == target) return true;

            // Handle duplicates: if nums[low], nums[mid], and nums[high] are equal
            if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                low = low + 1;
                high = high - 1;
                continue;
            }

            // Check if the left part is sorted
            if (nums[low] <= nums[mid]) {
                /* Eliminate the right part if target
                   exists in the left sorted part */
                if (nums[low] <= target && target <= nums[mid]) {
                    high = mid - 1;
                } 
                // Otherwise eliminate the left part
                else {
                    low = mid + 1;
                }
            } else {
                /* If the right part is sorted and
                   target exists in the right sorted part,
                   eliminate the left part */
                if (nums[mid] <= target && target <= nums[high]) {
                    low = mid + 1;
                } 
                // Otherwise eliminate the right part
                else {
                    high = mid - 1;
                }
            }
        }

        // If target is not found
        return false;
    }
}