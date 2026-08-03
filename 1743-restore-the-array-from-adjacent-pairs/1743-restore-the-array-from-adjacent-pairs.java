class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        // graph 
        HashMap<Integer, List<Integer>> graph = new HashMap<>();

        // creating the adjacency list
        for(int[] pair: adjacentPairs){
           
           int a = pair[0];
           int b = pair[1]; 
        
            graph.putIfAbsent(a, new ArrayList<>());
            graph.putIfAbsent(b, new ArrayList<>());

            graph.get(a).add(b);
            graph.get(b).add(a);
        
        }
        
        int n = adjacentPairs.length+1;
        int[] result = new int[n];

        int start=0;
        for(int key: graph.keySet()){
            if(graph.get(key).size() == 1){
                start = key;
                break;
            }
        }
        // first element
        result[0] = start;

        // second element
        // get(0) because the starting element has only one neighbour so it will the one which is in the arrayList of result[0] or start
        result[1] = graph.get(start).get(0);

        // now adding the left elements 
        for(int i =2 ;i<n;i++){
            List<Integer> neighbour = graph.get(result[i-1]);

            // if only one neighbour exists that's the next element 
            if(neighbour.size()== 1)
            result[i] = neighbour.get(0);
            else{
                // if two neighbours exist
                if(neighbour.get(0) == result[i-2])
                result[i] = neighbour.get(1);
                else 
                result[i] = neighbour.get(0);
            }
        }
        return result;
    }
}