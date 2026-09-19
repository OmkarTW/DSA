class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int low = 1;
        int high = (position[position.length-1]-position[0])/(m-1);
        int ans = 1;
        while(low <= high)
        {
            int mid = low +(high - low)/2;
            if(canWePlace(position, mid, m))
            {
                ans = mid;
                low = mid+1;
            }
            else
            {
                high = mid-1;
            }
        }
        return ans;
    }
    
    private boolean canWePlace(int[] arr, int dist, int cows)
    {
        int cntCows=1;
        int last = arr[0];
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]-last>=dist)
            {
                cntCows++;
                last = arr[i];
            }
            if(cntCows>=cows)
            {
                return true;
            }
        }
        return false;
    }
    
}