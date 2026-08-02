class Solution {
    public void setZeroes(int[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;
        boolean[] row = new boolean[n];
        boolean[] col = new boolean[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // if the current cell belong to row or col that should become zero then
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}