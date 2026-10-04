class Solution {
    public boolean checkValidString(String s) {

        int min = 0;
        int max = 0;

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                min++;
                max++;
            } 
            else if (ch == ')') {
                min--;
                max--;
            } 
            else { // '*'
                min--;  // treat '*' as ')'
                max++;  // treat '*' as '('
            }

            // Even with the most flexible interpretation,
            // we have too many ')'
            if (max < 0) {
                return false;
            }

            // min cannot be negative
            min = Math.max(min, 0);
        }

        // We need some interpretation with balance = 0
        return min == 0;
    }
}