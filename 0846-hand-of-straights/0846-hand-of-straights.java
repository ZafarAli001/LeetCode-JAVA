class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
       
       if(hand.length % groupSize != 0) return false;

    //    <Number, Frequency>
       TreeMap<Integer, Integer> map = new TreeMap<>();

    for(int num: hand)
    map.put(num, map.getOrDefault(num, 0)+1);

    while(!map.isEmpty()){
        int start = map.firstKey();

        for(int i =0;i<groupSize;i++){
            int curr = start +i;

            if(!map.containsKey(curr))
                return false;

            map.put(curr, map.get(curr) -1);

            if(map.get(curr) == 0)
            map.remove(curr);
            
        }
    }
    return true;
    }
}