class Solution {
    public long countCommas(long n) {

        long ans = 0;

        // First number that contains a comma
        long start = 1_000;

        // Numbers in this range have 1 comma
        long commas = 1;

        while (start <= n) {

            // End of the current comma range
            long end = start * 1000 - 1;

            // Don't go beyond n
            end = Math.min(end, n);

            // How many numbers are in this range?
            long count = end - start + 1;

            // Every number in this range has 'commas' commas
            ans += count * commas;

            // Move to the next comma range
            start *= 1000;
            commas++;
        }

        return ans;
    }
}