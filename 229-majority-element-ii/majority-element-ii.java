class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();

        //This solution is a modification of Moore's Voting Algorithm
        int count1 = 0;
        int count2 = 0;
        int element1 = Integer.MIN_VALUE;
        int element2 = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++){
            if(count1 == 0 && nums[i] != element2){
                element1 = nums[i];
                count1 = 1;
            }
            else if(count2 == 0 && nums[i] != element1){
                element2 = nums[i];
                count2 = 1;
            }
            else if(element1 == nums[i]) count1++;
            else if(element2 == nums[i]) count2++;
            else{
                count1--;
                count2--;
            }          
        }

        //Performing manual checks to make sure element1 and element2 are actual maority elements. 
        count1 = 0;
        count2 = 0;

        for(int i = 0;  i < nums.length; i++){
            if(nums[i] == element1) count1++;
            if(nums[i] == element2) count2++;
        }

        int mini = (nums.length / 3) + 1;

        if(count1 >= mini) ans.add(element1);
        if(count2 >= mini) ans.add(element2);

        return ans;
    }
}