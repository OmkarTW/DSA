class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        for (int i = 0; i < target.length(); i++) {
            int current = target.charAt(i) - 'a';

            // Try to keep the current character the same
            if (freq[current] > 0) {
                freq[current]--;
                continue;
            }

            // We can't match target[i].
            // Find the smallest character greater than target[i].
            for (int j = current + 1; j < 26; j++) {
                if (freq[j] > 0) {
                    StringBuilder ans = new StringBuilder(target.substring(0, i));
                    ans.append((char) ('a' + j));
                    freq[j]--;

                    // Put all remaining characters in sorted order
                    for (int k = 0; k < 26; k++) {
                        while (freq[k] > 0) {
                            ans.append((char) ('a' + k));
                            freq[k]--;
                        }
                    }

                    return ans.toString();
                }
            }

            // Can't make anything greater at this position.
            // We need to go back and change an earlier position.
            return findByBacktracking(s, target, i);
        }

        // s itself can only form target, so no STRICTLY greater permutation
        return findByBacktracking(s, target, target.length());
    }

    private String findByBacktracking(String s, String target, int pos) {
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // Try changing an earlier position, starting from the right.
        for (int i = pos - 1; i >= 0; i--) {
            int[] temp = freq.clone();

            // Restore characters used before i
            for (int k = 0; k < i; k++) {
                temp[target.charAt(k) - 'a']--;
            }

            int current = target.charAt(i) - 'a';

            for (int j = current + 1; j < 26; j++) {
                if (temp[j] > 0) {
                    StringBuilder ans = new StringBuilder(target.substring(0, i));
                    ans.append((char) ('a' + j));
                    temp[j]--;

                    for (int k = 0; k < 26; k++) {
                        while (temp[k] > 0) {
                            ans.append((char) ('a' + k));
                            temp[k]--;
                        }
                    }

                    return ans.toString();
                }
            }
        }

        return "";
    }
}