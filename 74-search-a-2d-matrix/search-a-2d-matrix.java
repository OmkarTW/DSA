class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
 
        int low = 0, high = n * m - 1;
        
        // Perform binary search
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            // Calculate the row and column
            int row = mid / m;
            int col = mid % m;
            
            // If target is found return true
            if (matrix[row][col] == target) return true;
            else if (matrix[row][col] < target) low = mid + 1;
            else high = mid - 1;
        }
        
        // Return false if target is not found
        return false; 
    }
}