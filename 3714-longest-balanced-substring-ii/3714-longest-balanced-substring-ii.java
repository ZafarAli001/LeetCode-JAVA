class Solution {
    public int longestBalanced(String s) {
        int n= s.length();
        int maxLen =0;

        // Case 1: One distinct Chraacter
        // for(int i = 0; i < n; i++){
        //     char ch =s.charAt(i);
        //     int len = 0;

        //     while(i<n && ch==s.charAt(i)) {
        //         i++;
        //         len++;
        //     } 
        //     maxLen = Math.max(maxLen, len);
        // }
        int j = 0;

        while (j < n) {
            char ch = s.charAt(j);
            int start = j;

        while (j < n && s.charAt(j) == ch) {
            j++;
        }

        maxLen = Math.max(maxLen, j - start);
        }

        // Case 2: two distninct char 
        maxLen = Math.max(maxLen, getLength(s, 'a'));
        maxLen = Math.max(maxLen, getLength(s, 'b'));
        maxLen = Math.max(maxLen, getLength(s, 'c'));

        // Case 3: All distinct char
        HashMap<String, Integer> map = new HashMap<>();
        int a = 0, b=0,c=0;
        map.put("0,0", -1);

        for(int i =0;i<n;i++){
            char ch = s.charAt(i);
            if(ch =='a') a++;
            else if(ch =='b') b++;
            else c++;

            int diff1 = a - b;
            int diff2 = a-c;
            String key = diff1 + "," + diff2;

            if(map.containsKey(key))
                maxLen = Math.max(maxLen, i- map.get(key));
            else 
                map.put(key, i);                    
        }
            return maxLen;
    }

    int getLength(String s , char skip){
        int mLen =0;
        // if skip char is a then we will take b, c
        // if skip char is b then we will take a, c
        // if skip char is c then we will take a, b

        char first = (skip == 'a') ? 'b' : 'a';
        char second = (skip == 'c') ? 'b' : 'c';
        
        int i =0, n = s.length();
        while(i < n){
            int c1 =0, c2 =0;
            int len = 0;

            HashMap<Integer, Integer> prev = new HashMap<>();
            prev.put(0, i-1);
            while(i < n && s.charAt(i) != skip){
                char ch = s.charAt(i);

                if (ch == first) c1++;
                else c2++;

               if(prev.containsKey(c1- c2)){
                   mLen = Math.max(mLen, i - prev.get(c1-c2)); 
                }else prev.put(c1-c2, i);
                i++;
            }
            i++;
        }
        return mLen;
    }
}