class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        int left = 0, top = 0;
        int right = matrix[0].length-1;
        int bottom = matrix.length-1;

        while (top <= bottom && left <= right) {

            // traversal from left to right
            for (int i = left; i <= right; i++)
                result.add(matrix[top][i]);
            top++;

            // traversal from top to bottom
            for (int i = top; i <= bottom; i++)
                result.add(matrix[i][right]);
            right--;

            // traversal from right to left
            if (top <= bottom) {
                for (int i = right; i >= left; i--)
                    result.add(matrix[bottom][i]);
                bottom--;
            }

            //traversal form bottom to top
            if (left <= right) {
                for (int i = bottom; i >= top; i--)
                    result.add(matrix[i][left]);
                left++;
            }
        }
        return result;
    }
}