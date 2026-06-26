class Solution {
    public int countSubstrings(String s) {
        int len = s.length();
        int [][] dp = new int[len][len];
        String result = ""; int count =0;
        for(int i=0;i<len;i++) // For len 1 
        {
        dp[i][i] = 1;
        count ++;
        if(i+1<len&&s.charAt(i)==s.charAt(i+1))
        {
        dp[i][i+1] = 1;
        count ++;
        }
        }
        for(int k=2;k<len;k++)
        {
            int i=0;
            for(int j=k;j<len;j++,i++)
            {
                if(s.charAt(i)==s.charAt(j)&&dp[i+1][j-1]==1)
                {
                    dp[i][j]= 1;
                    count ++;
                }
            }
        }
        return count ;
        
    }
}
