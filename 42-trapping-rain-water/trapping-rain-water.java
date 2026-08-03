class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int water = 0;

        while (left < right) {
            // Process the side with the smaller height boundary
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left]; // Update max left boundary
                } else {
                    water += leftMax - height[left]; // Calculate trapped water
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right]; // Update max right boundary
                } else {
                    water += rightMax - height[right]; // Calculate trapped water
                }
                right--;
            }
        }

        return water;
    }
}