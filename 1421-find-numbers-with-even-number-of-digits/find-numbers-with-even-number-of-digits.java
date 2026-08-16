import java.util.*;

class Solution {
    public int findNumbers(int[] nums) {
        int counter = 0;

        for(int num : nums){
            if(hasEvenNumberOfDigits(num)){
                counter++;
            }
        }

        return counter;
    }

    public boolean hasEvenNumberOfDigits(int num){
        int count = 0;
        
        if(num == 0){
            return false;
        }

        while(num > 0){
            num /= 10;
            count++;
        }

        return (count % 2 == 0);
    }
}