class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;
        for(int pile:piles){
            if(pile>high) high = pile;
        }
        while(low<=high){
            long hour = 0;
            int mid = low+(high-low)/2;
            for (int pile : piles) {
            hour += (pile + mid - 1) / mid;
}
            if(hour>h) low = mid+1;
            else high = mid-1;
        }
        return low;
    }
}