class Solution {
    HashSet<String> set = new HashSet<>();
    public Boolean f(String s,int i ,List<String> wordDict,Boolean [] dp)
    {
        if(i==s.length())
        return true;
        else
        {
            
            boolean flag = false;
            // for(int j=0;j<wordDict.size();j++)
            // {
            //     // System.out.println(wordDict.get(j));
            //     int len = wordDict.get(j).length();
            //     if(i+len>s.length())
            //     continue ;
            //     else if(set.contains(s.substring(i+len,s.length())))
            //     return true ;
            //     else if(wordDict.get(j).equals(s.substring(i,i+len)))
            //     {
            //     // System.out.println(set.size());
            //     flag = flag || f(s,i+len,wordDict);
            //     if(flag)
            //     {   
            //         System.out.println(set.size());
            //         set.add(s.substring(i+len,s.length()));
            //         break;
            //     }
            //     }
            // }
            if(dp[i]!=null)
            return dp[i];
            
            for(int j=i;j<=s.length();j++)
            {
                String word = s.substring(i,j);
                System.out.println(word);
                if(set.contains(word))
                {
                    flag = flag || f(s,j,wordDict,dp);
                    if(flag)
                    {
                        dp[i] = true;
                        break;
                    }
                    else dp[i] = false;
                }

            }
            return flag;

        }
        

    }
    public boolean wordBreak(String s, List<String> wordDict) {
        if(wordDict.size()==0)
        return false;
        if(s.length()==0)
        return true ;
        for(int i=0;i<wordDict.size();i++)
        set.add(wordDict.get(i));
        Boolean [] dp = new Boolean[s.length()] ;
        return f(s,0,wordDict,dp);

    }
}
