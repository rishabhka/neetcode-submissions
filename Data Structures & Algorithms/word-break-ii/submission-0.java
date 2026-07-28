class Solution {
    public List<String> dfs (String s, HashSet<String> set, int i ,HashMap<Integer,List<String>> map)
    {
        int n = s.length();
        if(i==s.length()) return new ArrayList<>(Arrays.asList("")) ;
        else if(map.get(i)!=null) return map.get(i) ;
        else
        {
            List<String> res = new ArrayList<>();
            for(int j=i;j<n;j++)
            {
                String word = s.substring(i,j+1);
                if(!set.contains(word)) continue ;
                List<String> temp = dfs(s,set,j+1,map) ;
                for (String tail : temp) {
    res.add(tail.isEmpty() ? word : word + " " + tail);
}
            }
            map.put(i,res);
            return res ;
        }
    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        for(String str : wordDict)
        set.add(str) ;
        HashMap<Integer,List<String>> map = new HashMap<>();
        return dfs(s,set,0,map);
    }
}