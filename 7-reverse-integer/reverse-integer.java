class Solution {
    public int reverse(int x) {
        long reversed = reverseHelper(x);

        if(reversed > Integer.MAX_VALUE || reversed < Integer.MIN_VALUE){
            return 0;
        }

        return (int) reversed;
    }

    public long reverseHelper(int n){
        long reverse = 0;

        while(n != 0){
            int digit = n % 10;
            reverse = (reverse * 10) + digit;
            n /= 10;
        }

        return reverse;
    }
}