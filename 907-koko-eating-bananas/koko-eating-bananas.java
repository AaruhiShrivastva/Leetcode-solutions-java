class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;
        
        // Find the maximum pile size to set the upper bound
        for (int pile : piles) {
            high = Math.max(high, pile);
        }
        
        int ans = high;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (canEatAll(piles, h, mid)) {
                ans = mid;        // Candidate answer found
                high = mid - 1;   // Try searching for a smaller valid speed
            } else {
                low = mid + 1;    // Speed is too slow, increase it
            }
        }
        
        return ans;
    }
    
    private boolean canEatAll(int[] piles, int h, int speed) {
        long hoursNeeded = 0;
        for (int pile : piles) {
            // Equivalent to Math.ceil((double) pile / speed) using integer arithmetic
            hoursNeeded += (pile + speed - 1) / speed;
            if (hoursNeeded > h) {
                return false; // Early exit if hours exceed limit
            }
        }
        return true;
    }
}