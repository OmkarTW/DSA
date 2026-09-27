class Solution {
    public String reverseParentheses(String s) {

        Stack<String> stack = new Stack<>();
        StringBuilder curr = new StringBuilder();

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                // Save what we have so far
                stack.push(curr.toString());
                curr.setLength(0);
            }

            else if (ch == ')') {
                // Reverse current substring
                curr.reverse();

                // Attach it to the previous string
                curr.insert(0, stack.pop());
            }

            else {
                // Normal character
                curr.append(ch);
            }
        }

        return curr.toString();
    }
}