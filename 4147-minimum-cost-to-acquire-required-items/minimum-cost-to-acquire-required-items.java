class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long min_1= (long)Math.max(need1, need2) * costBoth;
        long min_2= (long)cost1*need1 + (long)cost2*need2;

        long max=Math.max(need1, need2);
        long min=Math.min(need1,need2);
        long min_3=(long) min * costBoth;
        if(max==need1){
            min_3+=(long) cost1*(max-min);
        }
        else min_3+=(long) cost2*(max-min);

        return Math.min(min_1,Math.min(min_3, min_2));
    }
}