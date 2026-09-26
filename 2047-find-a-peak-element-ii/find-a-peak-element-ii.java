class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length;   
        int m = mat[0].length; 
        
        /* Initialize the lower bound for 
        and upper bound for binary search */
        int low = 0;           
        int high = m - 1;      
        
        // Perform binary search on columns
        while (low <= high) {
            int mid = (low + high) / 2;  
            
            /* Find the index of the row with the 
            maximum element in the middle column*/
            int row = maxElement(mat, mid);
            
            /* Determine the elements to left and 
            right of middle element in the found row */
            int left = mid - 1 >= 0 ? mat[row][mid - 1] : Integer.MIN_VALUE;
            int right = mid + 1 < m ? mat[row][mid + 1] : Integer.MIN_VALUE;
            
            /* Check if the middle element 
            is greater than its neighbors */
            if (mat[row][mid] > left && mat[row][mid] > right) {
                return new int[]{row,mid};  
            } 
            else if (left > mat[row][mid]) {
                high = mid - 1;  
            } 
            else {
                low = mid + 1;
            }
        }

        return new int[]{-1,-1}; 
    }

    private int maxElement(int[][] arr, int col) {
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        int index = -1;
        
        /* Iterate through each row to find the
        maximum element in the specified column*/
        for (int i = 0; i < n; i++) {
            if (arr[i][col] > max) {
                max = arr[i][col];
                index = i;
            }
        }
        //Return the index
        return index; 
    }
}