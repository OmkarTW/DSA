class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;

        //Sorting the array first
        Arrays.sort(nums);

        //Iterating to find triplets
        for(int i = 0; i < n; i++){
            if(i > 0 && nums[i] == nums[i - 1]) continue; //Skip duplicates at 'i' index

            int j = i + 1, k = n - 1;

            while(j <  k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum < 0){
                    j++; //Sum is less so increment 'j' in hopes to find greater num to find required sum
                }
                else if(sum > 0){
                    k--; //Sum is more so decrement 'k' in hopes to find smaller num to find required sum
                }
                else{
                    List<Integer> temp = new ArrayList<>(); //Adding everything to a temp list because triplet found
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    ans.add(temp);

                    j++;
                    k--;

                    //Skip duplicates of 'j' & 'k'
                    while(j < k && nums[j] == nums[j - 1]) j++;
                    while(j < k && nums[k] == nums[k + 1]) k--;

                }
            }

            
        }

        return ans;
    }
}