class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        // <ball, color>
        HashMap<Integer, Integer> ballColor = new HashMap<>();
        // <color, count>
        HashMap<Integer, Integer> colorCount = new HashMap<>();

        int[] result = new int[queries.length];

        for(int i =0;i<queries.length;i++){
            int ball = queries[i][0];
            int color = queries[i][1];
            Integer oldColor = ballColor.get(ball);

            // if ball has previousColor remove from colorCount
            if(oldColor != null){
                Integer count = colorCount.get(oldColor);
                if(count<=1){
                    colorCount.remove(oldColor);
                }else{
                    colorCount.put(oldColor, count -1 );
                }
            }

            // color new ball
            ballColor.put(ball, color);
            colorCount.put(color, colorCount.getOrDefault(color, 0)+1);

            result[i] = colorCount.size();
        }

    return result;
    }
}