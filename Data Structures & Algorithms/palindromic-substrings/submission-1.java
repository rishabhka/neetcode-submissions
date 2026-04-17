class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        if(n<2)
        return n;
        boolean  [][] dp = new boolean [n][n];
        int counter = 0;
        for(int i=0;i<n;i++)
        dp[i][i]=true;
        int gap =1;
        // (0,1) (1,2) (1,3) --- (0,2) (1,3)
        while(gap<n)
        {
            for(int i=0;i+gap<n;i++)
            {
                int j= i+gap;
                if(s.charAt(i)==s.charAt(j))
                {
                    if(Math.abs(j-i)==1)
                    {
                    dp[i][j] = true ;
                    counter ++;
                    }
                    else if(dp[i+1][j-1])
                    {
                    dp[i][j] = true ;
                    counter ++;
                    }
                    else
                    dp[i][j] = false ;
                }
                else
                dp[i][j]=false;

            }
            gap++;
        }
        // for(int i=0;i<n;i++)
        // {
        //     for(int j=0;j<n;j++)
        //     {
        //         if(dp[i][j])
        //         System.out.print("1");
        //         else
        //         System.out.print("0");
        //     }
        //     System.out.println();
        // }
        return counter + n ;
    }
}
