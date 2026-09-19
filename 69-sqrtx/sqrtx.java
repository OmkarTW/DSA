class Solution {
    public int mySqrt(int x) {
        int low = 1, high = x;
        
        // Binary search on the answer space
        while (low <= high) {
            int mid = low + (high - low) / 2;
            long val = (long) mid * (long) mid;  // mid*mid in 64-bit
            
            // Check if val is less than or equal to x
            if (val <= (long) x) {
                // Move to the right part
                low = mid + 1;
            } else {
                // Move to the left part
                high = mid - 1;
            }
        }
        
        // Return the floor of square root
        return high;
    }
}