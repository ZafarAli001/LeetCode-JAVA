class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < tickets.length; i++) 
            queue.offer(i);
        

        int time = 0;
        while (!queue.isEmpty()) {
            // get the tickets[i]
            int i = queue.poll();

            tickets[i]--;
            time++;

            // if the target person finishes return the time
            if (i == k && tickets[i] == 0)
                return time;

            // if person needs more tickets, move them to back
            if (tickets[i] > 0)
                queue.offer(i);
        }
        return time;
    }
}