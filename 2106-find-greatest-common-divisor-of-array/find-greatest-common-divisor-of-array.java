class Solution {
    public int findGCD(int[] nums) {
        int max = nums[0], min = nums[0];

        for(int i = 1; i < nums.length; i++){
            if(nums[i] < min){
                min = nums[i];
            }

            if(nums[i] > max){
                max = nums[i];
            }
        }

        return gcdHelper(min, max);
    }

    public int gcdHelper(int n1, int n2){
        while((n1 != 0) && (n2 != 0)){
            if(n1 > n2){
                n1 = n1 % n2;
            }
            else{
                n2 = n2 % n1;
            }

        }

        if(n2 == 0){
            return n1;
        }

        return n2;
    }
}