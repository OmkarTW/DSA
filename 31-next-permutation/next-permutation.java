class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length, breakIndex = -1;

        //First find a breakpoint if it exists. This is to get largest prefix match.
        for(int i = n - 2; i >= 0; i--){
            if(nums[i] < nums[i + 1]){
                breakIndex = i;
                break;
            }
        }

        //We get this if given is largest permutation. Reversing it will give us the smallest.
        if(breakIndex == -1){
            reverse(nums, 0, n - 1);
            return;
        }

        //If breakIndex exists then find first num greater than element at that index
        for(int i = n - 1; i >= breakIndex; i--){
            if(nums[i] > nums[breakIndex]){
                swap(nums, i, breakIndex);
                break;
            }
        }

        //Reverse right after the breakpoint
        reverse(nums, breakIndex + 1, n - 1);
        return;
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int start, int end){
        while(start < end){
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}