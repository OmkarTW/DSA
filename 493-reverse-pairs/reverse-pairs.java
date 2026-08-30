class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int low, int high){
        if(low >= high) return 0;

        int mid = low + (high - low) / 2, cnt = 0;

        cnt += mergeSort(nums, low, mid);
        cnt += mergeSort(nums, mid + 1, high);
        cnt += countPairs(nums, low, mid, high);
        merge(nums, low, mid, high);

        return cnt;
    }

    private int countPairs(int[] nums, int low, int mid, int high){
        int right = mid + 1, cnt = 0;

        for(int i = low; i <= mid; i++){
            while(right <= high && (long) nums[i] > 2L * nums[right]){
                right++;
            }
            cnt += (right - (mid + 1));
        }
        
        return cnt;
    }

    private void merge(int[] nums, int low, int mid, int high){
        List<Integer> temp = new ArrayList<>();

        int left = low, right = mid + 1;

        while(left <= mid && right <= high){
            if(nums[left] <= nums[right]){
                temp.add(nums[left++]);
            }
            else{
                temp.add(nums[right++]);
            }
        }

        while(left <= mid) temp.add(nums[left++]);
        while(right <= high) temp.add(nums[right++]);

        for(int i = low; i <= high; i++){
            nums[i] = temp.get(i - low);
        }
    }
} 