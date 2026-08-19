class Solution {
    public int longestPalindrome(String[] words) {
        HashMap<String, Integer> map = new HashMap<>();

        for(String word: words){
            map.put(word, map.getOrDefault(word, 0)+ 1);
        }
        
        int length = 0;
        boolean hasCenter = false;
        
        for(String word: map.keySet()){

            String reverse = new StringBuilder(word).reverse().toString();

            //Case 1:  if word has its own reverse
            if(word.equals(reverse)){
                int freq = map.get(word);

                // pair them: every 2 words contribute 4 characters
                length += (freq/2) * 4;
                
                // if only 1 is left it can be placed in center
                if(freq%2 == 1){
                    hasCenter = true;
                }
            //Case 2: word and reverse are different
            // }else if(map.containsKey(reverse)){
            }else if (map.containsKey(reverse)
                    && word.compareTo(reverse) < 0) {
                int pair = Math.min(map.get(word), map.get(reverse));

                // each pair contribute 4
                length += pair*4;
            } 
        }
        if(hasCenter == true) 
            length += 2;

        return length;
    }
}