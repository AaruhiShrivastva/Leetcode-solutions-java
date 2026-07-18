class Solution {
    public int uniquePaths(int r, int c) {
        int a[][] = new int[r][c];
        for(int i=0;i<r;i++){
            a[i][0]=1;
        }
        for(int j=0;j<c;j++){
            a[0][j]=1;
        }
        for(int i=1;i<r;i++){
            for(int j=1;j<c;j++){
                a[i][j]=a[i-1][j]+a[i][j-1];
            }
        }
        return a[r-1][c-1];
    }
}