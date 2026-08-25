import java.util.*;

class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
    

        for(int n : nums){
            set.add(n);
        }

        int multiple = k;

        while(set.contains(multiple)){
            multiple += k; 
        }

        return multiple;

    }
}