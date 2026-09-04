class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length, longest = 1;

        //Edge case when arr length is 0
        if(n == 0){
            return 0;
        }

        Set<Integer> set = new HashSet<>();

        //Putting all elements into the set
        for(int num : nums){
            set.add(num);
        }

        //Traversing Set
        for(int it : set){
            if(!set.contains(it - 1)){ //If 'it' is start of sequence
                int cnt = 1, x = it;
                while(set.contains(x+1)){
                    x++; //Move to next element
                    cnt++; //Update cnt
                }

                longest = Math.max(longest, cnt); //Update value of 'longest'
            }
        }

        return longest;
    }
}