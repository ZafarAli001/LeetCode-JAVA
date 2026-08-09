class Solution {
    public int[] queryResults(int limit, int[][] queries) {
      
      // ball and it's color <ball, color>
      HashMap<Integer, Integer> ballToColor = new HashMap<>();  
      //  color and it's count <color, count>
      HashMap<Integer, Integer> colorCount = new HashMap<>();  

    int n = queries.length;
    int[] answer = new int[n];

    for(int i=0;i<n;i++){

        int ball = queries[i][0];
        int color = queries[i][1];

            // Step 1 : If the ball already has a color,
            // remove its contribution.
            if (ballToColor.containsKey(ball)) {

                int oldColor = ballToColor.get(ball);

                // Decrease frequency of old color
                colorCount.put(oldColor, colorCount.get(oldColor) - 1);

                // If no ball has this color anymore,
                // remove it from the map.
                if (colorCount.get(oldColor) == 0) {
                    colorCount.remove(oldColor);
                }
            }

            // Step 2 : Assign the new color
            ballToColor.put(ball, color);

            // Increase frequency of new color
            colorCount.put(color, colorCount.getOrDefault(color, 0) + 1);

            // Step 3 : Number of distinct colors
            answer[i] = colorCount.size();
        } 
        return answer;
    }
}