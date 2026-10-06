class Solution {
    public String longestPalindrome(String s) {
    String ans = "";

    for(int i = 0;i<s.length();i++){

        // odd length palindrome 
        String odd = expand(s, i, i);
        if(odd.length() > ans.length())
            ans = odd; 

        // even length palindrome
        String even  = expand(s, i , i+1);
        if(even.length() > ans.length())
            ans = even;
    }    
    return ans;
    }

    private String expand(String s, int left, int right){
       // expand while characters are equal
        while(left>=0 && right<s.length() && s.charAt(right) == s.charAt(left)){
            left--;
            right++;
        }
        // taking left+1 instead left because while loop stops after the character no longer matches
        return s.substring(left+1,right);
    }
}