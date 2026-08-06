class Solution {
    public int smallestNumber(int n, int t) {
        int num = n;

        while (true) {
            int temp = num;
            int product = 1;

            while (temp > 0) {
                int digit = temp % 10;
                product *= digit;
                temp /= 10;
            }
            if (product % t == 0) {
                return num;
            }
            num++;
        }
    }
}