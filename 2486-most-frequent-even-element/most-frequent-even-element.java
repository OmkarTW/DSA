class Solution {
    public int mostFrequentEven(int[] nums) {
        int largest = nums[0];

        for(int i = 1; i < nums.length; i++){
            if(nums[i] > largest){
                largest = nums[i];
            }
        }

        int[] hashTable = new int[largest + 1];

        for(int i = 0; i < nums.length; i++){
            hashTable[nums[i]]++;
        }

        int maxFrequency = 0;
        int answer = -1;

        for(int i = 0; i < hashTable.length; i += 2){
            if(hashTable[i] > maxFrequency){
                maxFrequency = hashTable[i];
                answer = i;
            }
        }

        return answer;
    }
}