class Solution {
    public String longestPalindrome(String s) {
        int [][] dp = new int [s.length()][s.length()];
        String result = "";
        for(int i=0;i<s.length();i++)
        {
        result=s.substring(i,i+1);
        dp[i][i]= 1; 
        }
        for(int k=1;k<s.length();k++)
        {
            int i=0;
            
            for(int j = k;j<s.length();j++,i++)
            {
                if(s.charAt(i)==s.charAt(j)&&((j-i==1)||dp[i+1][j-1]==1))
                {
                dp[i][j]=1;
                if(j-i+1>result.length())
                result = s.substring(i,j+1);
                }
            }
        }
        return result ;
    }
}
