import java.util.*;

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int counter = 0, maxCount = 0;
        
        for(int i : nums){
            if(i == 1){
                counter++;
            }
            else{
                maxCount = Math.max(counter, maxCount);
                counter = 0;
            }
        }

        return maxCount > counter ? maxCount : counter;
    }
}