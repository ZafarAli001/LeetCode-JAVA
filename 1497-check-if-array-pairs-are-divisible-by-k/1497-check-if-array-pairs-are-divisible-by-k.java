class Solution {
    public boolean canArrange(int[] arr, int k) {

        //   a%k == remainder
        //   <Remainder, Freq. of Remainder>
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            // this exactly works like num % k but this formula is used to avoid -ve num 
            // as in java -num % k = -num 
            int remainder = ((num % k) + k) % k;
            map.put(remainder, map.getOrDefault(remainder, 0) + 1);
        }

        for(int rem : map.keySet()){
          
          // Case 1: if rem =0 it can only pair with 0 
            if(rem == 0){
                if(map.get(rem) % 2 != 0)
                return false;
            }

            // Case2: if rem = k/2 it can only pair with itself
            else if(2 * rem == k){
                if(map.get(rem) % 2 != 0)
                return false;
            }
            
            // now for normal remainder
            // if rem is 2 and k is 5
            //  complement will be 3 
            else{
                int complement = k - rem;

                if(map.get(rem).intValue() != map.getOrDefault(complement, 0))
                return false;
            }
        }
        return true;
    }
}