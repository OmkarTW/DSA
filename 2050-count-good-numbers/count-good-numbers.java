class Solution {
    public int countGoodNumbers(long n) {
        // Calculate number of even positions (0,2,4,...)
        long evenPositions = (n + 1) / 2;
        // Calculate number of odd positions (1,3,5,...)
        long oddPositions = n / 2;
        // Compute total good numbers modulo MOD
        long res = (modPow(5, evenPositions) * modPow(4, oddPositions)) % MOD;
        // Return result
        return (int) res;
    }

    final long MOD = 1000000007;
 
    // Function to calculate (base^exp) % MOD using fast exponentiation
    private long modPow(long base, long exp) {
        // Initialize result to 1
        long result = 1;
        // Take modulo of base
        base %= MOD;
        // Loop until exponent becomes 0
        while (exp > 0) {
            // If exponent is odd, multiply result with base
            if (exp % 2 == 1) result = (result * base) % MOD;
            // Square the base
            base = (base * base) % MOD;
            // Divide exponent by 2
            exp /= 2;
        }
        // Return final result
        return result;
    }
}