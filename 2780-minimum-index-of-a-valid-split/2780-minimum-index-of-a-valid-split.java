class Solution {
    public int minimumIndex(List<Integer> nums) {
        // int n = nums.length;
        int n = nums.size();
        
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num: nums)
            map.put(num, map.getOrDefault(num, 0)+ 1);

        int dominant = -1;
        int totalCount = 0;

        for(int num : map.keySet()){
            // checking if frequency is more than the half length of nums
            if(map.get(num) * 2>n ){
                dominant = num;
                totalCount = map.get(num);
                break;
            }
        }

        // if no dominant element no valid split is possible
        if(dominant == -1)
            return -1;

        // now proceeding to create the split 
        int leftCount = 0;
        for(int i =0;i< n-1;i++){

            if(nums.get(i) == dominant )
                leftCount++;

            // length of left split
            int leftLength = i+1;

            // count of dominant elements in right split
            int rightCount = totalCount - leftCount;
            int rightLength = n- leftLength;

            // checking if dominant element is dominant in both left and right side
            if((leftCount *2> leftLength) && (rightCount *2 > rightLength))
                return i;
        }
        return -1;
    }
}