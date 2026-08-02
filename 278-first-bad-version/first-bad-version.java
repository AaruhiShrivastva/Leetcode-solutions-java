/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;

        while (left < right) {
            // Prevent integer overflow when left + right > Integer.MAX_VALUE
            int mid = left + (right - left) / 2;

            if (isBadVersion(mid)) {
                // mid could be the first bad version, search left including mid
                right = mid;
            } else {
                // mid is good, the first bad version must be after mid
                left = mid + 1;
            }
        }

        return left;
    }
}