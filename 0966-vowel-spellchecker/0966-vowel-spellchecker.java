class Solution {

    public String convertVowels(String word){
    StringBuilder sb = new StringBuilder();

    for(char ch: word.toCharArray()){
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
            sb.append('*');
        else
            sb.append(ch);
    }
    return sb.toString();
}

    public String[] spellchecker(String[] wordlist, String[] queries) {

    // store exact word
    HashSet<String> exactSet = new HashSet<>();

    //  <lowerCase, orginalWord>
    HashMap<String, String> lowerMap = new HashMap<>();
    
    // <vowel-patter, OriginalWord>
    HashMap<String, String> vowelMap = new HashMap<>();

    for(String word: wordlist){
        
        // building exact word HashSet
        exactSet.add(word);

        // building lowerCase HashMap
        String lower = word.toLowerCase();
        if(!lowerMap.containsKey(lower))
            lowerMap.put(lower, word);

        // building vowel-pattern HashMap
        String pattern = convertVowels(lower);
        if(!vowelMap.containsKey(pattern))
            vowelMap.put(pattern, word);
    }   

    String[] answer = new String[queries.length];
    
    for(int i =0 ;i<queries.length;i++){

        String query = queries[i];

        // Case1: Exact Match
        if(exactSet.contains(query)){
            answer[i] = query;
            continue;
        }

        String lower = query.toLowerCase();
        if(lowerMap.containsKey(lower)){
            answer[i] = lowerMap.get(lower);
            continue;
        }

        String pattern = convertVowels(lower);
        if(vowelMap.containsKey(pattern)){
            answer[i] = vowelMap.get(pattern);
            continue;
        }

        answer[i] = "";
    }
    return answer;

    }
}