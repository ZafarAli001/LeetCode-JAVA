class Solution {
    public int numberOfSpecialChars(String word) {
    
     // loewrLast will store the last index of the lowerCase letter
     int[] lowerLast = new int[26];
     // upperFirst will store the first index of the upperCase letter
     int[] upperFirst = new int[26];   

    Arrays.fill(lowerLast, -1);
    Arrays.fill(upperFirst, -1);

    //  for(char ch: word.toCharArray()){
        for(int i =0;i<word.length();i++){
            char ch = word.charAt(i);
          
            if(ch >= 'a' && ch <= 'z'){
                lowerLast[ch - 'a'] = i;  // storing the last index of the char
            }else{ // for the upper char
                if(upperFirst[ch - 'A'] == -1)
                    upperFirst[ch - 'A'] = i;        
            }
        }
        int count = 0;
        for(int i =0;i<26;i++){
            if(lowerLast[i] != -1 && upperFirst[i] != -1 && lowerLast[i] < upperFirst[i])
                count++;
        }

        return count;
    }
}