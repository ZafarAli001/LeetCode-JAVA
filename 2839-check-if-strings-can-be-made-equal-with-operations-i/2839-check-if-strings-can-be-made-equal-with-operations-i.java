class Solution {
    public boolean canBeEqual(String s1, String s2) {
        
        // group position 0 and 1
        boolean group1 = samePair(
            s1.charAt(0), s1.charAt(2),
            s2.charAt(0), s2.charAt(2)
        );

        // gorup position 1 and 3
        boolean group2 = samePair(
            s1.charAt(1), s1.charAt(3),
            s2.charAt(1), s2.charAt(3)
        );
        return group1 && group2;
    }
    private boolean samePair(char ch1,char ch2,char ch3,char ch4){

        return (ch1 == ch3 && ch2 == ch4) ||
        (ch1 == ch4 && ch2 == ch3);
    }
}