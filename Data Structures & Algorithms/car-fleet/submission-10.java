class Solution {
    class Fleet
    {
        int pos ;
        Double time;
        Fleet(int pos,Double time)
        {
            this.pos=pos;
            this.time=time;
        }
    } 
    public int carFleet(int target, int[] position, int[] speed) {
        Fleet [] fleet = new Fleet[position.length];
        Stack<Fleet> stack = new Stack<>();
        for(int i=0;i<position.length;i++)
        {
            double time = (double) (target-position[i])/speed[i] ;
            fleet[i] = new Fleet(position[i],time);
        }
        Arrays.sort(fleet,(a,b)->
        {
            return Integer.compare(a.pos,b.pos);
        });
        for(int i=0;i<fleet.length;i++)
        {
            if(stack.isEmpty())
            stack.push(fleet[i]);
            else if(stack.peek().time<=fleet[i].time)
            {
             while(!stack.isEmpty()&&stack.peek().time<=fleet[i].time)
             {
            stack.pop();
             }
            stack.push(fleet[i]);
            }
            else
            stack.push(fleet[i]);
        }
        return stack.size();
    }
}
