class Solution {
    public int minSumOfLengths(int[] arr, int target) {

        int n = arr.length;

        // best[i] = minimum length of a target-sum
        // subarray ending at or before index i
        int[] best = new int[n];

        Arrays.fill(best, Integer.MAX_VALUE);

        int left = 0;
        int sum = 0;

        int answer = Integer.MAX_VALUE;

        // Length of the shortest valid subarray found so far
        int minLength = Integer.MAX_VALUE;

        for (int right = 0; right < n; right++) {

            // Expand the window
            sum += arr[right];

            // Shrink the window if sum becomes too large
            while (sum > target) {
                sum -= arr[left];
                left++;
            }

            // If current window has sum = target
            if (sum == target) {

                int currentLength = right - left + 1;

                /*
                 * If there was a valid subarray completely
                 * before 'left', combine it with current one.
                 *
                 * best[left - 1] represents the shortest
                 * valid subarray ending before this window.
                 */
                if (left > 0 && best[left - 1] != Integer.MAX_VALUE) {
                    answer = Math.min(
                        answer,
                        currentLength + best[left - 1]
                    );
                }

                // Update shortest valid subarray seen so far
                minLength = Math.min(minLength, currentLength);
            }

            /*
             * Carry forward the best answer.
             *
             * Even if there is no target-sum subarray ending
             * at 'right', we still want to remember the best
             * one found earlier.
             */
            if (right == 0) {
                best[right] = minLength;
            } else {
                best[right] = Math.min(best[right - 1], minLength);
            }
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}