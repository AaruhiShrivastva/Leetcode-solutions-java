import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // Step 1: Sort the array to use the two-pointer technique
        Arrays.sort(nums);
        
        // Initialize closestSum with the sum of the first three numbers
        int closestSum = nums[0] + nums[1] + nums[2];
        int n = nums.length;

        // Step 2: Iterate through each element as the first fixed element
        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            // Step 3: Use two pointers to find the closest sum
            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];

                // If exact target is found, return immediately
                if (currentSum == target) {
                    return currentSum;
                }

                // Update closestSum if currentSum is closer to target
                if (Math.abs(currentSum - target) < Math.abs(closestSum - target)) {
                    closestSum = currentSum;
                }

                // Adjust pointers based on current sum comparison
                if (currentSum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return closestSum;
    }
}