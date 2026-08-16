class Solution {
    public boolean isThree(int n) {
        int root = (int) Math.sqrt(n);

        if (root * root != n) {
            return false;
        }

        return isPrime(root);
    }

    public boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}