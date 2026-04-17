class Solution {
    public int f(int [] stoneValue,int chance,int i,int [][] dp)
    {
        if(i>=stoneValue.length)
        {
        // System.out.println("x");
        return 0;
        }
        else if(dp[chance][i]!=-1)
        return dp[chance][i];
        else
        {
            int sum =0 ; int x=Integer.MIN_VALUE;
            if(chance==1)
            x= Integer.MAX_VALUE;
            for(int j=i;j<=i+2&&j<stoneValue.length;j++)
            {
            if(chance==0)
            {
            sum = sum + stoneValue[j];
            x = Math.max(x,sum+f(stoneValue,1,j+1,dp));
            }
            else
            {
            sum = sum + stoneValue[j];
            // System.out.println(sum);
            x = Math.min(x,-sum+f(stoneValue,0,j+1,dp)); // Add -ve value here to make alice stone less
            }
            }
            dp[chance][i]= x ;
            return x;
        }

    }
    public String stoneGameIII(int[] stoneValue) {
        if(stoneValue.length==0)
        return "Tie";
        // 0 -> Alice Chance
        int [][] dp = new int [2][stoneValue.length+1] ;
        for(int i=0;i<2;i++)
        Arrays.fill(dp[i],-1);
        int sum = f(stoneValue,0,0,dp);  // Return Alice Maximum score 
        System.out.println(sum);
        
        if(sum==0)
        return "Tie";
        else if(sum<0)
        return "Bob";
        else return "Alice";
    }
}