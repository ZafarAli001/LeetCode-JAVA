class Solution {
    public int numberOfSpecialChars(String word) {
        int[] freqLower = new int[26];
        int[] freqUpper = new int[26];

        for(char ch: word.toCharArray()){
            if(ch >= 'a' && ch<='z')
                freqLower[ch - 'a']++;
            else 
                freqUpper[ch - 'A']++;
        }
        int count = 0;

        for(int i =0;i<26;i++){
            if(freqLower[i]>0 && freqUpper[i]> 0)
                count++;
        }
        return count;
    }
}