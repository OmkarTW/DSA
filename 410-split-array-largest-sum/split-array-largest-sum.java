class Solution {
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        int min = Integer.MIN_VALUE;
        int max = 0;
        if(n < k){
            return 0;
        }
        for(int num : nums){
            min = Math.max(min, num);
            max += num;
        }

        int soln = 0;
        while(min <= max){
            int mid = min + (max-min)/2;
            if(canFit(nums, mid, k)){
                soln = mid;
                max = mid-1;
            }
            else{
                min = mid + 1;
            }
        }

        return soln;
    }

    public boolean canFit(int[] nums, int perK, int k){
        int count = 1;
        int sum = 0;
        for(int num : nums){
            if((sum+num)>perK){
                count++;
                sum = num;
            }
            else{
                sum += num;
            }
        }
        return count <= k;
    }
}