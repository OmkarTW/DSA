class Solution {
    public boolean isPalindrome(int x) {
        if(x == reverseNumber(x)){
            return true;
        }

        return false;
    }

    public int reverseNumber(int n){
        int reverse = 0;

        while(n > 0){
            int digit = n % 10;
            reverse = (reverse * 10) + digit;
            n /= 10;
        }

        return reverse;
    }
}