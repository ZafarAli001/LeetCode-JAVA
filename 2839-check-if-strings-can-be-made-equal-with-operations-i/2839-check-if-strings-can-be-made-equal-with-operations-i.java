class Solution {

    public boolean canBeEqual(String s1, String s2) {

        // Test 1: No swap
        if (s1.equals(s2))
            return true;

        // Test 2: Swap positions (0,2)
        if (swap0_2(s1).equals(s2))
            return true;

        // Test 3: Swap positions (1,3)
        if (swap1_3(s1).equals(s2))
            return true;

        // Test 4: Swap both (0,2) and (1,3)
        String test = swap0_2(s1);

        if (swap1_3(test).equals(s2))
            return true;

        return false;
    }


    // Swap index 0 and index 2
    private String swap0_2(String s) {

        char[] arr = s.toCharArray();

        char temp = arr[0];
        arr[0] = arr[2];
        arr[2] = temp;

        return new String(arr);
    }


    // Swap index 1 and index 3
    private String swap1_3(String s) {

        char[] arr = s.toCharArray();

        char temp = arr[1];
        arr[1] = arr[3];
        arr[3] = temp;

        return new String(arr);
    }
}