class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if(n==1||n==0)
        return s ;
        int [][] dp = new int[n][n];
        int max = 0, global_i=0,global_j=0;
        for(int i=0;i<n;i++)
        {
               dp[i][i]=1;
        }
        int k= 1;
        while(k<=n-1)
        {
        for(int i=0;i+k<n;i++)
        {
                int j=i+k ;
                if(s.charAt(i)==s.charAt(j))
                {
                if(i==j-1)
                dp[i][j] =2;
                else if(dp[i+1][j-1]==0)
                dp[i][j] =0;
                else
                dp[i][j] =  dp[i+1][j-1] + 2 ;
                }
                if(dp[i][j]>max)
                {
                    max = dp[i][j] ;
                    global_i = i;
                    global_j = j ;
                }
        }
        k++;
        }
        return s.substring(global_i,global_j+1);
    }
}
