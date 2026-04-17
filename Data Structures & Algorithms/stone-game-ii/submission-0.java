class Solution {
    public int f(int [] piles,int i,int isAliceChance,int m,int [][][] dp)
    {
        if(piles.length<=i)
        return 0;
        else if(dp[isAliceChance][i][m]!=-1)
        return dp[isAliceChance][i][m];
        else
        {
                int max_sum = Integer.MIN_VALUE; int sum =0;
                if(isAliceChance ==1)
                    {
                     max_sum=Integer.MAX_VALUE ;   
                    }
                for(int j=i;(j<i+2*m)&&j<piles.length;j++)
                {
                    if(isAliceChance ==0)
                    {
                    sum = sum + piles[j] ;
                    max_sum = Math.max(sum + f(piles,j+1,1,Math.max(m,j-i+1),dp),max_sum);
                    }
                    else
                    {
                    // sum = sum - piles[j] ;
                    max_sum = Math.min(f(piles,j+1,0,Math.max(m,j-i+1),dp),max_sum);
                    }
                    
                }
            dp[isAliceChance][i][m]= max_sum;
            return dp[isAliceChance][i][m];
        }

    }
    public int stoneGameII(int[] piles) {
        if(piles.length==0)
        return 0;
        int [][][] dp = new int [2][piles.length+1][piles.length+1];
        for(int j=0;j<2;j++)
        for(int i=0;i<=piles.length;i++)
        Arrays.fill(dp[j][i],-1);

        return f(piles,0,0,1,dp);
    }
}