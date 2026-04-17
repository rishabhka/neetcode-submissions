class Solution {
    public boolean f(int[] matchsticks,int i,int edge1,int edge2,int edge3,int edge4)
    {
        if(edge1 == edge2 &&
   edge2 == edge3 &&
   edge3 == edge4 &&
   edge1 != 0&&i==matchsticks.length)
{
    return true;
}

        else if(i>=matchsticks.length)
        return false ;
        return f(matchsticks,i+1,edge1+matchsticks[i],edge2,edge3,edge4) ||
        f(matchsticks,i+1,edge1,edge2+matchsticks[i],edge3,edge4) ||
        f(matchsticks,i+1,edge1,edge2,edge3+matchsticks[i],edge4)||
        f(matchsticks,i+1,edge1,edge2,edge3,edge4+matchsticks[i]) ;
        

    }
    public boolean makesquare(int[] matchsticks) {
        if(matchsticks.length<4) return false;
        return f(matchsticks,0,0,0,0,0);
    }
}