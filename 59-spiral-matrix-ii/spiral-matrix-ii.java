class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        
        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;
        
        int val = 1;

        while (top <= bottom && left <= right) {
            // 1. Traverse Right (across top row)
            for (int j = left; j <= right; j++) {
                matrix[top][j] = val++;
            }
            top++;

            // 2. Traverse Down (along right column)
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = val++;
            }
            right--;

            // 3. Traverse Left (across bottom row)
            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    matrix[bottom][j] = val++;
                }
                bottom--;
            }

            // 4. Traverse Up (along left column)
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    matrix[i][left] = val++;
                }
                left++;
            }
        }

        return matrix;
    }
}