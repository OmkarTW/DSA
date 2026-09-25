class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        
        // Initialize the row and col
        int row = 0, col = m - 1;
 
        // Traverse the matrix from (0, m-1):
        while (row < n && col >= 0) {
            
            // Return true if target is found
            if (matrix[row][col] == target) return true;
            else if (matrix[row][col] < target) row++;
            else col--;
        }
        // Return false if target not found
        return false;
    }
}