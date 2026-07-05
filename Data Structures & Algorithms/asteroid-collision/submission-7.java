class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i=0;i<asteroids.length;i++)
        {
            int a = asteroids[i];
            while(!stack.isEmpty()&&a<0&&stack.peek()>0&&stack.peek()<-a)
            stack.pop();
            if(!stack.isEmpty()&&a<0&&stack.peek()==-a)
            stack.pop();
            else if (a > 0 || stack.isEmpty() || stack.peek() < 0) {
            stack.push(a);                    // no collision ahead → survives
        } 
        }
        int [] res = new int[stack.size()];
        for(int i=stack.size()-1;i>=0;i--)
        res[i] = stack.pop();
        return res ;
    }
}