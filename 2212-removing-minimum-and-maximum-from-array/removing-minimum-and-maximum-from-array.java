class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;

        int minimumIndex = 0, maximumIndex = 0;

        for(int i = 1; i < n; i++){
            if(nums[i] > nums[maximumIndex]){
                maximumIndex = i;
            }

            if(nums[i] < nums[minimumIndex]){
                minimumIndex = i;
            }
        }

        int left = Math.min(minimumIndex, maximumIndex);
        int right = Math.max(minimumIndex, maximumIndex);

        int fromFront = right + 1;
        int fromBack = n - left;
        int bothSides = (left + 1) + (n - right);

        return Math.min(fromFront, Math.min(fromBack, bothSides));
    }
}