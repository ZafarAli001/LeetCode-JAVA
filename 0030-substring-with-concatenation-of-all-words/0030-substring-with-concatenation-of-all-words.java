class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        
        if (s.length() == 0 || words.length == 0)
            return result;

        HashMap<String, Integer> target = new HashMap<>();
        for (String word : words) {
            target.put(word, target.getOrDefault(word, 0) + 1);
        }


        int wordLen = words[0].length();
        int totalWords = words.length;

        for (int start = 0; start < wordLen; start++) {
            HashMap<String, Integer> window = new HashMap<>();
            int left = start;
            // in a single iteration count tells how many valid words in the window
            int count = 0;

            //right+= wordLen basically means jumping instead of jumping one character jump one word
            for (int right = start; right + wordLen <= s.length(); right += wordLen) {
                String word = s.substring(right, right + wordLen);

                // if invalid word
                if (!target.containsKey(word)) {
                    window.clear();
                    count = 0;
                    left = right + wordLen;
                    continue;
                } else {
                    window.put(word, window.getOrDefault(word, 0) + 1);
                    count++;
                }

                // removing extra word
                while (window.get(word) > target.get(word)) {
                    String leftWord = s.substring(left, left + wordLen);

                    window.put(leftWord, window.get(leftWord) - 1);

                    left += wordLen;
                    count--;
                }

                // found one valid window
                if(count == totalWords){
                    result.add(left);

                    // sliding window by one word
                    String leftWord = s.substring(left, left+wordLen);
                    window.put(leftWord, window.get(leftWord)-1);
                    left += wordLen;
                    count--; 
                }
            }
        }
        return result;
    }
}