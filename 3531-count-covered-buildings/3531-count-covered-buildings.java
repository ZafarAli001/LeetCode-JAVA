class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        // for ever row x: 
        HashMap<Integer, Integer> minY = new HashMap<>();
        HashMap<Integer, Integer> maxY = new HashMap<>();
        
        // for every column y:
        HashMap<Integer, Integer> maxX = new HashMap<>();
        HashMap<Integer, Integer> minX = new HashMap<>();

        // finding bundaries for every row row and column 
        for(int[] building: buildings){

            int x = building[0];
            int y = building[1];

            // row boundaries
            minY.put(x, Math.min(minY.getOrDefault(x, Integer.MAX_VALUE), y));
            maxY.put(x, Math.max(maxY.getOrDefault(x, Integer.MIN_VALUE), y));

            // column boundaries
            minX.put(y, Math.min(minX.getOrDefault(y, Integer.MAX_VALUE), x));
            maxX.put(y, Math.max(maxX.getOrDefault(y, Integer.MIN_VALUE), x));
        }

        int count =0;

        // checking every boudaries
        for(int[] building: buildings){
            int x = building[0];
            int y = building[1];

            if(minY.get(x) < y && maxY.get(x)> y
                && minX.get(y) < x && maxX.get(y) > x)
                count++;
        }
    return count;
    }
}