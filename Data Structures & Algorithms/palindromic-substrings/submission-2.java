class Solution {
    public int countSubstrings(String s) {
        int n = s.length() ;
        boolean [][] dp = new boolean [n][n] ;

        int count =0;
        for(int i=0;i<n;i++)
        {
        dp[i][i] = true ;
        count ++;
        }
        int k =1 ;
        while(k<n)
        {
            for(int i=0;i+k<n;i++)
            {
                    int j = i+ k;
                    if(s.charAt(i)==s.charAt(j))
                    {
                    System.out.print(i+" "+j+" ");
                    if(i==j-1)
                    dp[i][j] = true ;
                    else if(dp[i+1][j-1])
                    dp[i][j] = true ;
                    if(dp[i][j])
                    count ++;
                    }
                
            }
            k++;
        }
        for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                System.out.print(dp[i][j]+ " ");
                }
                System.out.println("");
            }
        return count ;
    }
}
