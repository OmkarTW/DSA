class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Size of two given arrays
        int n1 = nums1.length, n2 = nums2.length;

        /* Ensure nums1 is not larger than 
        nums2 to simplify implementation*/
        if (n1 > n2) return findMedianSortedArrays(nums2, nums1);

        int n = n1 + n2;
        
        // Length of left half
        int left = (n1 + n2 + 1) / 2; 

        // Apply binary search
        int low = 0, high = n1;
        while (low <= high) {
            
            // Calculate mid index for arr1
            int mid1 = (low + high) >>> 1; // This basically is (low + high) / 2
            
            // Calculate mid index for arr2
            int mid2 = left - mid1; 

            // Calculate l1, l2, r1, and r2
            int l1 = (mid1 > 0) ? nums1[mid1 - 1] : Integer.MIN_VALUE;
            int r1 = (mid1 < n1) ? nums1[mid1] : Integer.MAX_VALUE;
            int l2 = (mid2 > 0) ? nums2[mid2 - 1] : Integer.MIN_VALUE;
            int r2 = (mid2 < n2) ? nums2[mid2] : Integer.MAX_VALUE;

            if (l1 <= r2 && l2 <= r1) {
                // If condition for finding median
                if (n % 2 == 1) return Math.max(l1, l2);
                else return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
            } 
            else if (l1 > r2) {
                // Eliminate the right half of arr1
                high = mid1 - 1;
            } else {
                // Eliminate the left half of arr1
                low = mid1 + 1;
            }
        }
        // Dummy statement
        return 0; 
    }
}