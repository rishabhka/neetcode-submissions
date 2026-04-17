class Solution {
    public String minWindow(String s, String t) {
        if(s.equals(t))
        return s ;
        else if(t.length()>s.length())
        return "" ;
        int p =0; int q =0 ;
        int n = s.length();
        int count =0 ; int min_len = Integer.MAX_VALUE ;int i = 0 ; int j =0;
        HashMap<Character,Integer> map = new HashMap<>();
        for(char c : t.toCharArray())
        {
            map.put(c,map.getOrDefault(c,0)+1);
            count ++;
        }
        while(q<n)
        {
            if(map.containsKey(s.charAt(q))){
                if(map.get(s.charAt(q))>0)
                count -- ;
                map.put(s.charAt(q),map.get(s.charAt(q))-1); 
            }
            while(count == 0)
            {
                if(min_len>q-p+1)
                {
                    min_len = q-p+1;
                    i = p;
                    j = q;
                }
                if(map.containsKey(s.charAt(p)))
                {
                   map.put(s.charAt(p),map.get(s.charAt(p))+1); 
                   if(map.get(s.charAt(p))>0)
                   count ++ ;
                }
                p++;
            }
            q++;   
        }
        System.out.println(i+" "+j);
        return min_len== Integer.MAX_VALUE? "" : s.substring(i,j+1);
        
    }
}
