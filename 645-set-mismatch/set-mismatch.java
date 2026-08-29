class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;

        long Sn = ((long) n * (n + 1)) / 2; //Sum of first n natural numbers
        long S2n = ((long) n * (n + 1) * (2*n + 1)) / 6; //Sum of sqares of first n natural numbers

        long S1 = 0, S2 = 0;

        //Regular sum and sum of sqaures of array elements
        for(int i = 0; i < n; i++){
            S1 += nums[i];
            S2 += (long) nums[i] * (long) nums[i];
        }

        //From the equations
        long value1 = S1 - Sn;
        long value2 = S2 - S2n;
        value2 /= value1;

        long missingNumber = (value1 + value2) / 2;
        long repeatingNumber = missingNumber - value1; 

        return new int[]{(int)missingNumber, (int)repeatingNumber};
    }
}