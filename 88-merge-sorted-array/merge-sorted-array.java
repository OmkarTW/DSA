import java.util.*;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1;
        int lastIndex = m + n - 1;

        while(j >= 0){  //While elements still exist in the nums2
            if(i >= 0 && (nums1[i] >= nums2[j])){ 
                nums1[lastIndex] = nums1[i];
                lastIndex--;
                i--;
            }
            else{
                nums1[lastIndex] = nums2[j];
                lastIndex--;
                j--;

            }
        } 
    }
} 