class Solution {
    public boolean checkPerfectNumber(int num) {
        int sum = 1, originalNum = num;

        if(num <= 1){
            return false;
        }

        for(int i = 2; i <= Math.sqrt(num); i++){
            if(num % i == 0){
                sum += i;
            

                if(i != (num/i)){
                    sum += num / i;
                }
            }    
        }

        return (sum == originalNum);
    }
}