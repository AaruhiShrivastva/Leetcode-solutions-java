import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        if (nums == null || nums.length < 2 || indexDiff <= 0 || valueDiff < 0) {
            return false;
        }

        Map<Long, Long> buckets = new HashMap<>();
        long bucketSize = (long) valueDiff + 1;

        for (int i = 0; i < nums.length; i++) {
            long num = (long) nums[i];
            long bucketId = getBucketId(num, bucketSize);

            // Check if current bucket already has an element
            if (buckets.containsKey(bucketId)) {
                return true;
            }

            // Check adjacent bucket to the left
            if (buckets.containsKey(bucketId - 1) && Math.abs(num - buckets.get(bucketId - 1)) <= valueDiff) {
                return true;
            }

            // Check adjacent bucket to the right
            if (buckets.containsKey(bucketId + 1) && Math.abs(num - buckets.get(bucketId + 1)) <= valueDiff) {
                return true;
            }

            // Insert current element into its bucket
            buckets.put(bucketId, num);

            // Maintain sliding window size of indexDiff
            if (i >= indexDiff) {
                long oldBucketId = getBucketId((long) nums[i - indexDiff], bucketSize);
                buckets.remove(oldBucketId);
            }
        }

        return false;
    }

    private long getBucketId(long val, long size) {
        if (val >= 0) {
            return val / size;
        } else {
            return (val + 1) / size - 1;
        }
    }
}