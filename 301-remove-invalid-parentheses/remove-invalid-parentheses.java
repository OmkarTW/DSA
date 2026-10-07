class Solution {

    public List<String> removeInvalidParentheses(String s) {

        List<String> ans = new ArrayList<>();

        remove(s, ans, 0, 0, '(', ')');

        return ans;
    }

    private void remove(
            String s,
            List<String> ans,
            int start,
            int check,
            char open,
            char close) {

        int balance = 0;

        for (int i = check; i < s.length(); i++) {

            if (s.charAt(i) == open) {
                balance++;
            } 
            else if (s.charAt(i) == close) {
                balance--;
            }

            // Too many closing parentheses
            if (balance < 0) {

                for (int j = start; j <= i; j++) {

                    if (s.charAt(j) == close &&
                        (j == start || s.charAt(j - 1) != close)) {

                        remove(
                            s.substring(0, j) + s.substring(j + 1),
                            ans,
                            j,
                            i,
                            open,
                            close
                        );
                    }
                }

                return;
            }
        }

        // No extra ')' remaining.
        // Now check for extra '(' from the other direction.
        String reversed = new StringBuilder(s).reverse().toString();

        if (open == '(') {
            remove(reversed, ans, 0, 0, ')', '(');
        } 
        else {
            ans.add(reversed);
        }
    }
}