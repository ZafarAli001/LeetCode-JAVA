class Solution {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        int[] horizontal = new int[hFences.length + 2];
        int[] vertical = new int[vFences.length + 2];

        // subsituting all values of horizontal fences in horizontal
        horizontal[0]  = 1;

        for(int i = 0; i < hFences.length; i++)
            horizontal[i+1] = hFences[i];
        
        horizontal[horizontal.length-1] = m;

        // substituing all values of vertical fences in vertical
        vertical[0] = 1; 
        for(int i =0;i<vFences.length;i++)
            vertical[i+1] = vFences[i];
        
        vertical[vertical.length-1] = n;

        Arrays.sort(horizontal);
        Arrays.sort(vertical);

        // calculating all horizontal distances 
        HashSet<Integer> hDistances = new HashSet<>();

        for(int i =0;i<horizontal.length;i++){
            for(int j = i+1;j<horizontal.length;j++){
                hDistances.add(horizontal[j] - horizontal[i]);
            }
        } 

        // calculating all vertical distances
        HashSet<Integer> vDistances = new HashSet<>();
        for(int i =0;i<vertical.length;i++){
            for(int j =i+1;j<vertical.length;j++){
                vDistances.add(vertical[j]- vertical[i]);
            }
        }

        // finding common max distance in hDistances and vDistances
        int maxSide = 0;
        for(int distance: hDistances){
            if(vDistances.contains(distance)){
                maxSide = Math.max(maxSide, distance);
            }
        }

        // return -1 if no common differences
        if(maxSide == 0)
            return -1;

        // calculting area
        long area = (long)maxSide * maxSide;

        return (int)(area % 1_000_000_007);

    }
}