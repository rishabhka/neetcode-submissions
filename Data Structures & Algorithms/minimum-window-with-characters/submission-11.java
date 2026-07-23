class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> map = new HashMap<>(); String res  = "" ;
        for(int i=0;i<t.length();i++)
        map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0)+1) ;
        int p =0 ; int q = 0; int count = t.length(); int min_len = Integer.MAX_VALUE;
        while(q<s.length()||count ==0 )
        {
            if(count ==0) // shrink to right
            {
                if(min_len>q-p+1)
                {
                    min_len = q-p+1 ; res = s.substring(p,q);
                }
                if(map.containsKey(s.charAt(p)))
                {
                   map.put(s.charAt(p),map.get(s.charAt(p))+1) ;
                   if(map.get(s.charAt(p))>0) count ++ ;
                }
                p++;
            }
            else
            {
                if(map.containsKey(s.charAt(q)))
                {
                    map.put(s.charAt(q),map.get(s.charAt(q))-1) ;
                    if(map.get(s.charAt(q))>=0) count -- ;
                }
                q++;
            }

        }
        return res ;
    }
}
