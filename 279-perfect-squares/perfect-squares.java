import java.util.Arrays;

class Solution {
    public int numSquares(int n) {
        // dp[i] will store the least number of perfect squares that sum to i
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        // Base case
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            // Check all perfect squares less than or equal to i
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        return dp[n];
    }
}