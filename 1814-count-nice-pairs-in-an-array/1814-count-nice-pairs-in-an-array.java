class Solution {

    // main strategy  
    // Since,   nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])
    // so also, nums[i] - rev(nums[i]) == nums[j] - rev(nums[j])

    public int reverse(int num) {
        int rev = 0;
        while (num > 0) {
            int digit = num % 10;
            rev = rev * 10 + digit;
            num = num / 10;
        }
        return rev;
    }

    public int countNicePairs(int[] nums) {
        
        // Since that number can be too large, return it modulo 109 + 7.
        int MOD = 1_000_000_007;

        // <Difference, Frequency>
        HashMap<Integer, Integer> map = new HashMap<>();

        long nicePair = 0;

        for(int num:nums){
            
            int diff = num - reverse(num);

            // If this difference has already appeared,
            // every previous occurrence forms a nice pair
            if(map.containsKey(diff))
                nicePair = (nicePair + map.get(diff)) % MOD;

            // Increase the frequency of the difference 
            map.put(diff, map.getOrDefault(diff, 0)+ 1);
        }
        return (int)nicePair;
    }
}