import java.util.*;

class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                stack.push(matrix[i][j]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = matrix[0].length - 1; j >= 0; j--) {
                int val = stack.pop();

                matrix[j][i] = val;
            }
        }
    }
}