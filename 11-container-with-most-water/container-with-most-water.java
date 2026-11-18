class Solution {
    public int maxArea(int[] h) {
        int l=h.length;
        int s=0;
        int e=l-1;
        int ar=0;
        while(s<=e){
            int a1=Math.min(h[s], h[e]) * ((e)-s);
            ar= Math.max(ar, a1);
            if(h[s]<h[e])s++;
            else e--;
        }

        return ar;
    }
}