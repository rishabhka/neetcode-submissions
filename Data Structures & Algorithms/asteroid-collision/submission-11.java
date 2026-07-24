class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i=0;i<asteroids.length;i++)
        {
            if(stack.isEmpty())
            stack.push(asteroids[i]);
            else if(stack.peek()+asteroids[i]==0&&stack.peek()>0)
            stack.pop();
            else if(stack.peek()>0&&asteroids[i]<0)
            {
                while(!stack.isEmpty()&&stack.peek()>0&&asteroids[i]<0)
                {
                    if(stack.peek()==Math.abs(asteroids[i])) {stack.pop() ; break;  }
                    if(stack.peek()<Math.abs(asteroids[i]))
                    stack.pop() ;
                    else break ;
                }
                if(!stack.isEmpty()&&(stack.peek()+asteroids[i]==0)) continue ;
                if(stack.isEmpty()||stack.peek()<0)
                stack.push(asteroids[i]) ;
            }
            else stack.push(asteroids[i]);

        }
        int [] res = new int[stack.size()];
        for(int i = stack.size()-1;i>=0;i--)
        res[i] = stack.pop();
        return res;
    }
}