class Solution {
    public int equalPairs(int[][] grid) {
        int result = 0;

        HashMap<List<Integer>, Integer> map = new HashMap<>();

        for (int i = 0; i < grid.length; i++) {
            List<Integer> row = new ArrayList<>();

            for (int j = 0; j < grid.length; j++) {
                row.add(grid[i][j]);
            }

            map.put(row, map.getOrDefault(row, 0) + 1);
        }
        for (int j = 0; j < grid.length; j++) {
            List<Integer> col = new ArrayList<>();

            for (int i = 0; i < grid.length; i++) {
                col.add(grid[i][j]);
            }

            result += map.getOrDefault(col, 0);
        }
        return result;
    }
}