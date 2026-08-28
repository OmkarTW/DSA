class Solution {
    public int maxSubArray(int[] nums) {
        long maxiSum = Long.MIN_VALUE, sum = 0;


        //Using Kadane's Algorithm

        for(int i = 0; i < nums.length; i++){
            sum += nums[i];

            if(sum > maxiSum){
                maxiSum = sum;
            }

            if(sum < 0){
                sum = 0;
            }
        }

        return (int) maxiSum;
       
    }
}