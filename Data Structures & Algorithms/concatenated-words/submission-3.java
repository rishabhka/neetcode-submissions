class Solution {
    HashSet<String> set = new HashSet<>();
    HashMap<String,Boolean> dp = new HashMap<>();
    public boolean dfs(String s)
    {
        if(dp.containsKey(s)) return dp.get(s) ;
            for(int j=1;j<s.length();j++)
            {
                String prefix = s.substring(0,j);
                String suffix = s.substring(j,s.length());
                if(set.contains(prefix)&&set.contains(suffix))
                return true ;
                else if(set.contains(prefix)&&dfs(suffix))
                {
                dp.put(s,true);
                return true ;
                }
            }
            dp.put(s,false);
            return false ;

    }
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        
        for(String s: words)
        set.add(s);
        List<String> result = new ArrayList<>();
        for(String s:words)
        {
            if(dfs(s))
            result.add(s);
        }
        return result ;
    }
}