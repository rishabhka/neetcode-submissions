class Solution {
    class Fleet
    {
        int pos ;
        int speed;
        Fleet(int pos,int speed)
        {
            this.pos=pos;
            this.speed=speed;
        }
    }
    public int carFleet(int target, int[] position, int[] speed) {
        Fleet [] fleet = new Fleet[position.length] ;
        for(int i=0;i<position.length;i++)
        {
            fleet[i] = new Fleet(position[i],speed[i]);
        }
        Arrays.sort(fleet,(a,b)->Integer.compare(b.pos,a.pos));
        Stack<Fleet> stack = new Stack<>();

        for(int i=0;i<fleet.length;i++)
        {
            if(stack.isEmpty())
            stack.push(fleet[i]);
            else if((float)(target-stack.peek().pos)/(stack.peek().speed)
            >= (float)(target-fleet[i].pos)/(fleet[i].speed))
            continue;
            else
            stack.push(fleet[i]);
        }
        return stack.size();
    }
}
