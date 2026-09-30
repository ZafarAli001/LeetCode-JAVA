class Solution {
    public int[] prisonAfterNDays(int[] cells, int n) {

        // <(String)State, first seen day>
        HashMap<String, Integer> seen = new HashMap<>();

        while(n>0){
            String state = Arrays.toString(cells);

            if(seen.containsKey(state)){
                
                // cycleLength = firstSeenDay - SeenAgainDay(currentDay)
                int cycleLength =  seen.get(state) - n;
                
                // like if seen then skip the complete cycle 
                // For example, if `N = 10` and `cycleLength = 3`, then `10 % 3 = 1`. This means 10 days
                // contain **3 complete cycles** (`3 + 3 + 3 = 9`) plus **1 remaining day**. Since
                // complete cycles bring us back to the same state, we can skip those 9 days and only simulate the remaining 1 day.
    
                n %= cycleLength;
            }else{
                seen.put(state, n);
            }

            if(n>0){
                n--;
                cells = calculateNextState(cells);
            }
        }
        return cells;
    }

    private int[] calculateNextState(int[] cells){
        int[] next = new int[8];
        // the first and last cell have one only one neighbour 
        next[0] = 0;
        next[7] = 0;

        for(int i =1;i<7;i++){
            if (cells[i - 1] == cells[i + 1]) 
                next[i] = 1;
             else 
                next[i] = 0;
            
        }
        return next;
    }
}