class Solution {
    public List<Integer> partitionLabels(String s) {
        // int start = 0 ;
        List<Integer> result = new ArrayList<>();
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++)
        map.put(s.charAt(i),i) ;
        // int last_idx = 0; 
        for(int i=0;i<s.length();)
        {
            int idx = map.get(s.charAt(i));
            for(int j=0;j<=idx;j++)
            {
                if(s.charAt(j)!=s.charAt(i))
                {
                    if(idx<map.get(s.charAt(j)))
                    {
                        idx=map.get(s.charAt(j));
                    }
                }

            }
            int start = i ;
            i = idx + 1;
            result.add(i-start);
            
        }
        return result ;
    }
}
