class Solution {
    public int minimumPushes(String word) {
        int cost = 0;

        for (int i = 0; i < word.length(); i++) {
            // cost per character for word.length()
            //  0-7 will be 1 ; for 8-15 will be 2; for 16-23 will be 3 and so on
            cost += i / 8 + 1;
        }
        return cost;
    }
}