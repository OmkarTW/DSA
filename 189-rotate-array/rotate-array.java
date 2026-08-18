class Solution {
    public void rotate(int[] nums, int k) {
        int size = nums.length;
        k %= size;

        if(k == 0){
            return;
        }

        reverseArray(nums, 0, size - 1);
        reverseArray(nums, 0, k - 1);
        reverseArray(nums, k, size - 1);
    }

    public void reverseArray(int[] arr, int start, int end){
    while(start < end){
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;

        start++;
        end--;
    }
}

    
}