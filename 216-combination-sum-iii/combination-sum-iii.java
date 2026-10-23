class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> nums = new ArrayList<>();
        // Call the recursive function with initial parameters
        func(n, 1, nums, k, ans);
        return ans;
    }

    private void func(int sum, int last, List<Integer> nums, int k, List<List<Integer>> ans) {
        // If the sum is zero and the number of elements is k
        if (sum == 0 && nums.size() == k) {
            // Add the current combination to the answer
            ans.add(new ArrayList<>(nums));
            return;
        }
        // If the sum is less than or equal to zero or the number of elements exceeds k
        if (sum <= 0 || nums.size() > k) return;
 
        // Iterate from the last number to 9
        for (int i = last; i <= 9; i++) {
            // If the current number is less than or equal to the sum
            if (i <= sum) {
                // Add the number to the current combination
                nums.add(i);
                // Recursive call with updated sum and next number
                func(sum - i, i + 1, nums, k, ans);
                // Remove the last number to backtrack
                nums.remove(nums.size() - 1);
            } else {
                // If the number is greater than the sum, break the loop
                break;
            }
        }
    }
}