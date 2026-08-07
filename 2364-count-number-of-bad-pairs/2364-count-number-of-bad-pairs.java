class Solution {
    public long countBadPairs(int[] nums) {
        
        int n = nums.length;
        long totalPairs = (long) n * (n-1) / 2;
        long goodPairs = 0;

        // < nums[i]-i, frequency>
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i =0;i<n;i++){
            
            int key = nums[i] - i;

            // calculating good pair instead of bad pair as goodPair = total - badPair
            goodPairs += map.getOrDefault(key, 0);

            map.put(key, map.getOrDefault(key, 0)+1);
        }

       return totalPairs - goodPairs;
    }
}