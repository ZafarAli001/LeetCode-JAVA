class Solution {
    public int minCharacters(String a, String b) {
        int[] freqA = new int[26];
        int[] freqB = new int[26];

        for(char ch : a.toCharArray())
            freqA[ch - 'a']++;
        for(char ch: b.toCharArray())   
            freqB[ch - 'a']++;
        
        int ans = Integer.MAX_VALUE;

        // trying every bounday for condition 1 and 2
        for(int boundary =0; boundary< 25;boundary++){
            int changes1 = 0;
            int changes2 = 0;

            for(int j =0;j<26;j++){
                if(j<= boundary){
                    // condition1: a <= boundary && b > boundary
                    changes1 += freqB[j];

                    // condition2 : b<= boundary && a> boundary
                    changes2 += freqA[j];
                }else{
                    // condition1: a<= boundary
                    changes1 += freqA[j];

                    // condition2: b<= boundary
                    changes2 += freqB[j];
                }
            }
            ans = Math.min(ans,changes1);
            ans = Math.min(ans,changes2);
        }
        // condition3: both string must contatin only one distinct character 
        for(int ch = 0;ch<26;ch++){
            int changes =0;
            changes += a.length() - freqA[ch];
            changes += b.length() - freqB[ch];

            ans = Math.min(ans, changes);
        }
        return ans;
    }
}