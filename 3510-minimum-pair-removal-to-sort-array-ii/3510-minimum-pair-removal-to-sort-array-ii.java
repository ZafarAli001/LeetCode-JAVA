class Solution {

    class Pair implements Comparable<Pair>{
        int idx;
        long val, sum;
        // previous and next node
        Pair left, right;

        // constructor
        Pair(int idx, long value){
            this.idx = idx;
            this.val = value;
        }

        // this tells TreeSet how to order pair objects 
        @Override
        public int compareTo(Pair p){
            if(this.right == null|| p.right == null)
                return this.right == null ? 1: -1;

            long diff = this.sum - p.sum;

            return diff != 0 ? (diff<0 ? -1 : 1) : (this.idx - p.idx);
        }
    }

    public int minimumPairRemoval(int[] nums) {
        // TreeSet keeps pair objects sorted according to compareTo()
        TreeSet<Pair> set = new TreeSet<>();
        int mismatch = 0;

        Pair prev = null;

        // Doubly LinkedList
        for(int i =0;i<nums.length;i++){
            Pair curr = new Pair(i, nums[i]);
            
            
            if(prev == null) // first element
                prev = curr;
            else{
                if(curr.val<prev.val)
                    mismatch++;
                
                // connecting nodes prev <-->curr
                prev.right = curr;
                curr.left = prev;

                prev.sum = prev.val + curr.val;
                
                // adding prev to TreeSet b'coz prev + prev.right makes valid pair
                set.add(prev);

                // moving forward
                prev = curr;
            }
        }
        
        // add the last node 
        set.add(prev);
        // no. of merge operation
        int cnt =0;

        while(mismatch > 0){
           
           // Greedy: get the best pair having min sum
            Pair best = set.pollFirst();

            // merging two nodes
            Pair del = best.right;
            Pair next = del.right;

            // Node before 'best'
            Pair left = best.left;

            // 1. Remove old mismatches
            if(best.val> del.val)   
                mismatch--;

            if(next != null && del.val> next.val)
                mismatch--;

            if(left != null && left.val> best.val)
                mismatch--;

            // 2. Remove old pair objects from TreeSet

            set.remove(del);

            if(left != null)
                set.remove(left);
            
            // 3. Merge best and del
            long newVal = best.val + del.val;

            best.right = next;

            if(next != null)
             next.left = best;

            best.val = newVal;

            // 4. Calculating new sum

             if (next != null) 
                best.sum = best.val + next.val;
             else 
                best.sum = 0;
            
            // 5. Add new mismatch relationships
            
             if (next != null && best.val > next.val) 
                mismatch++;
    
            if (left != null && left.val > best.val) 
                mismatch++;

            // 6. Updating left node's pair
            if (left != null) {
                left.right = best;
                left.sum = left.val + best.val;

                set.add(left);
            }

            // Add updated best node
            set.add(best);
        
           cnt++;
        }
        return cnt;
    } 
}