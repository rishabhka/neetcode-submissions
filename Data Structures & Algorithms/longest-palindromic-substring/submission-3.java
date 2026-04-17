class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int max_i =0 ;
        int max_j = 0;
        int max_val = 1;
        if(n==1||n==0)
        return s;
        else
        {
            int [][] dp = new int [n][n];
            for(int i=0;i<n;i++)
            dp[i][i] = 1;
            int k=1 ;
            while(k<=n-1)
            {
            for(int i=0;i<n;i++)
            {
                for(int j=i+k;j<n;j++)
                {
                    if(s.charAt(i)==s.charAt(j))
                    {
                    int x = dp[i+1][j-1] ;
                    if(Math.abs(i-j)==1)
                    dp[i][j] = x + 2 ;
                    else if(x==0)
                     dp[i][j] = 0 ;
                     else 
                     dp[i][j] = x + 2 ;
                    }
                    else
                    dp[i][j] = 0;
                    
                    if(dp[i][j]>max_val)
                    {
                        
                        max_val = dp[i][j];
                         max_i =i ;
                         max_j = j;
                    }
                    i++;

                }
            }
            k++;
            }
            String sub = s.substring(max_i,max_j+1);
            return sub;
        }
    }
}
