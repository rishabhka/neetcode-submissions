class Solution {
    public int f(int[] cost,int i,int[] memo)
    {
        if(i<=1)
        return 0;
        if(memo[i]!=-1)
        return memo[i];
        else 
        {
            int x = f(cost,i-1,memo)+cost[i-1] ;
            int y = f(cost,i-2,memo)+cost[i-2] ;
            memo[i] = Math.min(x,y);
            return memo[i] ;
        }

    }
    public int minCostClimbingStairs(int[] cost) {
        int n= cost.length ;
        int [] memo = new int[n+1];
        Arrays.fill(memo,-1);
        memo[0] = 0;
        memo[1] = 0 ;
        if(n==0||n==1)
        return 0;
        else return f(cost,n,memo);
    }
}
