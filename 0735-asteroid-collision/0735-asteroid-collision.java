class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        stack.push(asteroids[0]);

        for (int i = 1; i < asteroids.length; i++) {
            int current = asteroids[i];
            boolean alive = true;

            // collision is possible when stack top is +ve and current is -ve 
            while (!stack.isEmpty() && stack.peek() > 0 && current < 0) {

                if (stack.peek() < -current) {
                    // stack top explodes
                    stack.pop();
                    // current will survie but while loop checks for another collision
                } else if (stack.peek() == -current) {
                    // both asteroids will explode
                    stack.pop();
                    alive = false;
                    break;
                } else {
                    // stack top is bigger then current wll explode
                    alive = false;
                    break;
                }
            }
            if (alive)
                stack.push(current);
        }
        
        int[] result = new int[stack.size()];
        for (int i = 0; i < stack.size(); i++)
            result[i] = stack.get(i);
        
        return result;
    }
}