class Solution {
    public int totalNumbers(int[] digits) {

        int[] freq = new int[10];

        // Count frequency of every digit
        for (int digit : digits) {
            freq[digit]++;
        }

        int count = 0;

        // Choose hundreds digit: 1-9
        for (int i = 1; i <= 9; i++) {

            if (freq[i] == 0) continue;
            freq[i]--;

            // Choose tens digit: 0-9
            for (int j = 0; j <= 9; j++) {

                if (freq[j] == 0) continue;
                freq[j]--;

                // Choose units digit: even digits
                for (int k = 0; k <= 8; k += 2) {

                    if (freq[k] == 0) continue;

                    count++;
                }

                // Restore tens digit
                freq[j]++;
            }

            // Restore hundreds digit
            freq[i]++;
        }

        return count;
    }
}