class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();
        int currentPrefixSum = 0, subarrayCount = 0;

        // Setting 0 in the map.
        prefixSumMap.put(0, 1);
        for (int i = 0; i < n; i++) {
            // Add current element to the prefix sum:
            currentPrefixSum += nums[i];

            /* Calculate the value to remove
            (currentPrefixSum - k)*/
            int sumToRemove = currentPrefixSum - k;

            /* Add the number of subarrays 
            with the sum to be removed*/
            subarrayCount += prefixSumMap.getOrDefault(sumToRemove, 0);

            /*Update the count of current
            prefix sum in the map*/
            prefixSumMap.put(currentPrefixSum, prefixSumMap.getOrDefault(currentPrefixSum, 0) + 1);
        }
        return subarrayCount;
    }
}