class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {

        int n = nums.length;
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            // map.put(nums[i])
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        List<Integer> result = new ArrayList<>();

        for (int index : queries) {
            int num = nums[index];

            ArrayList<Integer> indexes = map.get(num);

            if (indexes.size() == 1) {
                result.add(-1);
                continue;
            }

            // using built in binary search method for finding index position
            int pos = Collections.binarySearch(indexes, index);

            // checking prev occurences
            int prev;
            if (pos == 0)
                prev = indexes.get(indexes.size() - 1);
            else
                prev = indexes.get(pos - 1);

            // next occurences
            int next;
            if (pos == indexes.size() - 1)
                next = indexes.get(0);
            else
                next = indexes.get(pos + 1);

            // Circular distance to previous
            int diffPrev = Math.abs(index - prev);
            int distPrev = Math.min(diffPrev, n - diffPrev);

            // Circular distance to next
            int diffNext = Math.abs(index - next);
            int distNext = Math.min(diffNext, n - diffNext);

            result.add(Math.min(distPrev, distNext));
        }
        return result;
    }
}