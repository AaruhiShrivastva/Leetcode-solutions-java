class Solution {
    public boolean checkPerfectNumber(int num) {
        // Perfect numbers must be positive and greater than 1
        if (num <= 1) {
            return false;
        }

        int sum = 1; // 1 is a divisor for all numbers > 1
        
        // Find divisors up to sqrt(num)
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                sum += i;
                // If divisors are different (i.e., not a perfect square root), add the paired divisor
                if (i * i != num) {
                    sum += num / i;
                }
            }
        }

        return sum == num;
    }
}