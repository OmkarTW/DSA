class Solution {

    int ans = 0;

    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return ans;
    }

    // Returns {sum of subtree, number of nodes in subtree}
    private int[] dfs(TreeNode node) {

        // Empty subtree
        if (node == null) {
            return new int[]{0, 0};
        }

        // Get sum and count from left subtree
        int[] left = dfs(node.left);

        // Get sum and count from right subtree
        int[] right = dfs(node.right);

        // Calculate total sum of current subtree
        int sum = left[0] + right[0] + node.val;

        // Calculate total number of nodes in current subtree
        int count = left[1] + right[1] + 1;

        // Integer division automatically rounds down
        int average = sum / count;

        // Check whether current node equals subtree average
        if (node.val == average) {
            ans++;
        }

        // Return sum and count to the parent node
        return new int[]{sum, count};
    }
}