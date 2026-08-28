class Solution {
    public void sortColors(int[] nums) {
            //Using Dutch National Flag Algorithm


        int low = 0, mid = 0, high = nums.length - 1;

        while(mid <= high){
            if(nums[mid] == 0){
                swap(nums, low, mid);
                low++; //Moving both pointers ahead to accomadate extra 0 added
                mid++;
            }
            else if(nums[mid] == 1){
                mid++; //Moving this ahead because '1' is essentially in its right place
            }
            else{
                swap(nums, mid, high);
                high--; //Moving pointer to accomadate extra '2'
            }
        }
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}