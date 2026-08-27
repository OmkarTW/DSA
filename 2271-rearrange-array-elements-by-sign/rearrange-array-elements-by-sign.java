class Solution {
    public int[] rearrangeArray(int[] nums) {
        int size = nums.length;

        int[] ans = new int[size];
        int posIndex = 0, negIndex = 1;

        for(int i = 0; i < size; i++){
            if(nums[i] > 0){
                ans[posIndex] = nums[i];
                posIndex += 2;
            }
            else{
                ans[negIndex] = nums[i];
                negIndex += 2;
            }
        }

        return ans;
    }
}