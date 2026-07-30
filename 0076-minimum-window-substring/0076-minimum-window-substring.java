class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> target = new HashMap<>();
        for(char ch: t.toCharArray()){
            target.put(ch, target.getOrDefault(ch, 0)+1);
        }
        HashMap<Character, Integer> window = new HashMap<>();

        int left =0;
        int right =0;

        int formed = 0;
        int required =target.size();

        int minLen = Integer.MAX_VALUE;
        int start  =0;
        
        while(right<s.length()){
            char ch = s.charAt(right);
            window.put(ch, window.getOrDefault(ch, 0)+1);

            if(target.containsKey(ch) && window.get(ch).equals(target.get(ch))){
                formed++;
            }

            while( left<=right && formed==required){
                
                if(right-left+1<minLen){
                    minLen = right-left+1;
                    start = left;
                }

                char leftChar = s.charAt(left);
                window.put(leftChar, window.get(leftChar)-1);

                if(target.containsKey(leftChar) && window.get(leftChar)<target.get(leftChar)){
                    formed--;
                }
                left++;
            }
            right++;
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start+minLen);
    }
}