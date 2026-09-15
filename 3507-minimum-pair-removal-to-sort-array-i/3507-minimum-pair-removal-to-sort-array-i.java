class Solution {
    public int minimumPairRemoval(int[] nums) {

        ArrayList<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }

        // count = no. of times pair is removed
        int count = 0;

        while (!isSorted(list)) {

            int minSum = Integer.MAX_VALUE;
            int minIndex = -1;

            for (int i = 0; i < list.size()-1; i++) {
                int currSum = list.get(i) + list.get(i + 1);

                if (currSum < minSum) {
                    minSum = currSum;
                    minIndex = i;
                }
            }

            // Mering the pair
            list.set(minIndex, minSum);
            list.remove(minIndex + 1);

            count++;
        }
        return count;
    }

    private boolean isSorted(ArrayList<Integer> list) {

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < list.get(i - 1))
                return false;
        }
        return true;
    }
}