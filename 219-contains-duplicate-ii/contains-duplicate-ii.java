import java.util.HashSet;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            // If the element is already in the set, a duplicate within distance k exists
            if (set.contains(nums[i])) {
                return true;
            }

            // Add the current element to the set
            set.add(nums[i]);

            // Keep the sliding window size to at most k
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }

        return false;
    }
}