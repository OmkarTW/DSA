class Solution {
    public int minInsertions(String s) {

        int open = 0;
        int insertions = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                open++;
            } else {

                // If the next character is also ')',
                // we have a pair of closing brackets.
                if (i + 1 < s.length() && s.charAt(i + 1) == ')') {
                    i++;
                } else {
                    // Insert one ')' to complete the pair.
                    insertions++;
                }

                // Match the closing pair with an opening '('.
                if (open > 0) {
                    open--;
                } else {
                    // Insert an '(' because none is available.
                    insertions++;
                }
            }
        }

        // Every remaining '(' needs two ')'.
        return insertions + 2 * open;
    }
}