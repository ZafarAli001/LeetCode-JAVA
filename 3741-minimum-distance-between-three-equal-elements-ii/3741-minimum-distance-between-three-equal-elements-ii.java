class Solution {
    public int minimumDistance(int[] nums) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++)
            // map.computeIfAbsent(nums[i], k -> new ArrayList<>().add(i));
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);

        int minDistance = Integer.MAX_VALUE;

        for (ArrayList<Integer> indexes : map.values()) {
            if (indexes.size() < 3)
                continue;

            for (int i = 0; i < indexes.size() - 2; i++) {
                // Since i < j < k,
                // |i-j| + |j-k| + |k-i|
                // = (j-i) + (k-j) + (k-i)
                // = 2 * (k-i)
                // So the middle index j cancels out.
                int firstIndex = indexes.get(i);
                int secondIndex = indexes.get(i + 2);

                int distance = 2 * (secondIndex - firstIndex);

                minDistance = Math.min(distance, minDistance);

            }
        }
        if (minDistance == Integer.MAX_VALUE)
            return -1;

        return minDistance;

    }
}