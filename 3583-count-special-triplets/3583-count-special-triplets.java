class Solution {
      
       static final int MOD = 1_000_000_007;
    
    public int specialTriplets(int[] nums) {       
       
        HashMap<Integer, Integer> rightMap = new HashMap<>();
        HashMap<Integer, Integer> leftMap = new HashMap<>();
    
        for(int num: nums)
            rightMap.put(num, rightMap.getOrDefault(num, 0)+1);
        
        long result = 0;

        for(int num : nums){
            rightMap.put(num, rightMap.get(num)-1);

            int leftCount = leftMap.getOrDefault(num *2, 0);
            int rightCount = rightMap.getOrDefault(num *2, 0);

            result += (long) leftCount * rightCount;
            result %= MOD;

            // move current element to left
            leftMap.put(num, leftMap.getOrDefault(num, 0) + 1);
        }
        return (int) result;
    }
}