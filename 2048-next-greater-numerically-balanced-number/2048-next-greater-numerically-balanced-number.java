class Solution {
    private boolean isBalanced(int num){
       HashMap<Integer, Integer> map = new HashMap<>();
        
        while(num>0){
            int digit = num%10;
            map.put(digit, map.getOrDefault(digit, 0)+1);
            num/=10;
        }

        for(int digit: map.keySet()){
            if(map.get(digit)!= digit)
            return false;
        }
        return true;
    }

    public int nextBeautifulNumber(int n) {
        int i = n+1;
        
        while(true){
            if(isBalanced(i))
            return i;
        i++;
        }
    }
}