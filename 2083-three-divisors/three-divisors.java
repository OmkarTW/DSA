class Solution {
    public boolean isThree(int n) {
        int counter = 0;
        
        for(int m = 0; m <= n; m++){
            for(int k = 0; k <= n; k++){
                if(n == k * m){
                    counter++;
                }
            }
        }

        if(counter == 3){
            return true;
        }

        return false;
    }
}