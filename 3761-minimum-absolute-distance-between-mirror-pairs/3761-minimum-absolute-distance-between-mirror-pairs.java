class Solution {
    private int reverse(int num) {
        int reversed = 0;

        while (num > 0) {
            int digit = num % 10;
            reversed = reversed * 10 + digit;
            num /= 10;
        }
        return reversed;
    }

    public int minMirrorPairDistance(int[] nums) {

        // <reverse(nums[i]), i>
        HashMap<Integer, Integer> map = new HashMap<>();

        int minDistance = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {

            if (map.containsKey(nums[i])) {
                int prevIndex = map.get(nums[i]);

                minDistance = Math.min(minDistance, i - prevIndex);
            }

            map.put(reverse(nums[i]), i);
        }
        
        if (minDistance == Integer.MAX_VALUE)
            return -1;

        return minDistance;
    }
}