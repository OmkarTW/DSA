class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();  // List to store all subsets
        List<Integer> current = new ArrayList<>();  // Temporary list to store the current subset
        backtrack(0, nums.length, nums, current, ans);  // Start the recursive process
        return ans;  // Return the list of all subsets
    }

    private void backtrack(int index, int n, int[] nums, List<Integer> current, List<List<Integer>> ans) {
        // Base case: if the index reaches the length of the array,
        // add the current subset to the answer list
        if (index == n) {
            ans.add(new ArrayList<>(current));
            return;
        }
 
        // Recursive case: Exclude the current element and move to the next element
        backtrack(index + 1, n, nums, current, ans);
 
        // Include the current element in the subset and move to the next element
        current.add(nums[index]);
        backtrack(index + 1, n, nums, current, ans);
 
        // Backtrack: remove the last added element to explore other subsets
        current.remove(current.size() - 1);
    }
}