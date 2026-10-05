class Solution {
    public int findTheLongestSubstring(String s) {

        // 00000 --> 0
        int bitMask = 0;
        // <bitMask, firstOccurence>
        HashMap<Integer, Integer> map = new HashMap<>();
        // Initializing map
        map.put(0, -1);
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == 'a')
                bitMask ^= 1; // 1 == 00001
            else if (ch == 'e')
                bitMask ^= 2; // 2 == 00010
            else if (ch == 'i')
                bitMask ^= 4; //4 == 00100
            else if (ch == 'o')
                bitMask ^= 8; //8 == 01000
            else if (ch == 'u')
                bitMask ^= 16; //16 == 10000

            if (map.containsKey(bitMask)) {
                int length = i - map.get(bitMask);
                maxLength = Math.max(maxLength, length);
            } else
                map.put(bitMask,i);
        }
        return maxLength;
    }
}