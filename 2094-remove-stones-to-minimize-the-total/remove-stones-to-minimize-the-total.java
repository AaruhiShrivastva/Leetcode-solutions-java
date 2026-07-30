class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> p = new PriorityQueue<>(Collections.reverseOrder());
        
    
        for (int i=0;i<piles.length;i++) {
            p.add(piles[i]);
            
        }
        for(int i=1;i<=k;i++){
            int first = p.poll();
            p.add(first-(first/2));
        }
        int sum = 0;
        while(!p.isEmpty()){
            sum+=p.peek();
            p.poll();
        }
        return sum;

    }
}