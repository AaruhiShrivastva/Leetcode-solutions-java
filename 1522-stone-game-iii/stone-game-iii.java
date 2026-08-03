class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int[] dp = new int[n + 1]; // dp[i] stores max score difference from index i to end

        // Traverse backwards from the end of the array
        for (int i = n - 1; i >= 0; i--) {
            int maxDiff = Integer.MIN_VALUE;
            int currentTakeSum = 0;

            // Player can take 1, 2, or 3 stones
            for (int k = 0; k < 3 && i + k < n; k++) {
                currentTakeSum += stoneValue[i + k];
                int nextDiff = dp[i + k + 1];
                maxDiff = Math.max(maxDiff, currentTakeSum - nextDiff);
            }

            dp[i] = maxDiff;
        }

        // Evaluate outcome from Alice's perspective at start index 0
        if (dp[0] > 0) {
            return "Alice";
        } else if (dp[0] < 0) {
            return "Bob";
        } else {
            return "Tie";
        }
    }
}