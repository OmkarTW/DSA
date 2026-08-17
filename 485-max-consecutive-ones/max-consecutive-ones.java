import java.util.*;

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int counter = 0, maxCount = 0;
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1){
                counter++;
                maxCount = Math.max(counter, maxCount);
            }
            else{
                counter = 0;
            }
        }

        return maxCount;
    }
}