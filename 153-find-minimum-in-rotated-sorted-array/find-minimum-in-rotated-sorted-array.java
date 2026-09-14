class Solution {
    public int findMin(int[] nums) {
        // Initialize low and high indices
        int low = 0, high = nums.length - 1;
        
        // Initialize ans to maximum integer value
        int ans = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = (low + high) / 2;
            
            // Check if left part is sorted
            if (nums[low] <= nums[mid]) {
                /* Update ans with minimum 
                of ans and arr[low] */
                ans = Math.min(ans, nums[low]);
                
                // Move to the right part
                low = mid + 1;
            } else {
                /* Update ans with minimum 
                   of ans and arr[mid] */
                ans = Math.min(ans, nums[mid]);
                
                // Move to the left part
                high = mid - 1;
            }
        }
        // Return the minimum element found
        return ans;
    }
}