class Solution {

    public List<String> generateParenthesis(int n) {

        List<String> ans = new ArrayList<>();

        backtrack("", 0, 0, n, ans);

        return ans;
    }

    private void backtrack(
        String curr,
        int open,
        int close,
        int n,
        List<String> ans
    ) {

        // We have used all parentheses
        if (curr.length() == 2 * n) {
            ans.add(curr);
            return;
        }

        // Add '(' if we still have some left
        if (open < n) {
            backtrack(
                curr + "(",
                open + 1,
                close,
                n,
                ans
            );
        }

        // Add ')' only if there is an unmatched '('
        if (close < open) {
            backtrack(
                curr + ")",
                open,
                close + 1,
                n,
                ans
            );
        }
    }
}
