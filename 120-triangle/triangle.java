class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int a[] = new int[n];
        for(int i=0;i<n;i++){
            a[i]=triangle.get(n-1).get(i);
        }
        for(int j=n-2;j>=0;j--){
            for(int k=0;k<=j;k++){
                a[k]=Math.min(a[k],a[k+1])+triangle.get(j).get(k);
            }
        }
        return a[0];
    }
}