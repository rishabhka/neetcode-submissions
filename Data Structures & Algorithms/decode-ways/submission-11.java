class Solution {
    public int f(String s,int i,int [] dp)
    {
        if(s.substring(i,s.length()).startsWith("0"))
        return 0;
        else if(i>=s.length())
        return 1 ;
        else if(dp[i]!=-1)
        return dp[i];
        else
        {
            // Take 1st character 
            int p = f(s,i+1,dp);
            int q=0;
            // Check if two characters valid 
            if(i<s.length()-1&&Integer.valueOf(s.substring(i,i+2))<=26)
            q = f(s,i+2,dp);
            dp[i]= p+q;
            return dp[i];
        }
    }
    public int numDecodings(String s) {
        if(s.startsWith("0"))
        return 0;
        int [] dp = new int[s.length()+1];
        List<String> result = new ArrayList<>();
        Arrays.fill(dp,-1);
        return f(s,0,dp);


    }
}
