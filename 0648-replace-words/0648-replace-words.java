class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
       HashSet<String> set = new HashSet<>(dictionary);

       // seperating the word of sentence  
       String[] words = sentence.split(" ");

        StringBuilder result = new StringBuilder();

        for(String word : words){
            
            StringBuilder prefix = new StringBuilder();
            boolean found = false;

            for(char ch : word.toCharArray()){

                prefix.append(ch); // building the prefix

                if(set.contains(prefix.toString())){
                    result.append(prefix);
                    found = true;
                    break;
                }
            }

            if(!found)
            result.append(word);

            result.append(" ");
        }

        // remove the last extra space
        result.deleteCharAt(result.length()-1);

        return result.toString();
    }
}