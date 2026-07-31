class Solution {
    public String longestPalindrome(String s) {
        int n = s.length() ;
        int [][] memo= new int [n][n] ;
        for(int i=0;i<n;i++)
        memo[i][i] = 1; 
        int max_len = Integer.MIN_VALUE ; int max_i = 0 ; int max_j = 0 ;
        for(int k=1;k<n;k++)
        {
            int i =0 ;
            int j = i + k ;
            while(j<n)
            {
                if(i==j-1&&s.charAt(i)==s.charAt(j))
                memo[i][j]=1 ;
                else if(s.charAt(i)==s.charAt(j)&&memo[i+1][j-1]==1)
                memo[i][j]=1 ;
                if(memo[i][j]==1)
                {
                    if(max_len<j-i+1)
                    {
                       max_len=j-i+1 ; 
                       max_i = i ;
                       max_j = j ;
                    }
                }
                i++;
                j++;
            }
        }
        
        return s.substring(max_i,max_j+1) ;
    }
}
