class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        
        // < [i,j], freq>
        HashMap<String, Integer> map = new HashMap<>();
        int pairCount = 0;


        for(int i =0;i<dominoes.length;i++){
            int x = dominoes[i][0];
            int y = dominoes[i][1];

            // normalizing x and y 
            // [1,2] -> [1,2];  [2,1]=> [1,2]
            int a = Math.min(x,y);
            int b = Math.max(x,y);

            String key = a+" "+ b;

            pairCount += map.getOrDefault(key, 0);

            map.put(key, map.getOrDefault(key,0) + 1);

        }
        return pairCount;
    }
}