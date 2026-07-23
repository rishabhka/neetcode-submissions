class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()) return false;
        HashMap<Character,Integer> map = new HashMap<>();   
        int p=0; int q =0 ; int cnt = 0;
        for(int i=0;i<s1.length();i++)
        {
        map.put(s1.charAt(i),map.getOrDefault(s1.charAt(i),0)+1);
        cnt ++; 
        }
        while(q<s2.length())
        {
            if(cnt==0)
            {
                // shift p right and check
                if(s1.length()==(q-p+1)) return true ;
                if(map.containsKey(s2.charAt(p)))
                {
                if(map.get(s2.charAt(p))>=0) cnt ++ ;    
                map.put(s2.charAt(p),map.get(s2.charAt(p))+1);
                }
                p++;
            }
            else
            {
                if(map.containsKey(s2.charAt(q)))
                {
                if(map.get(s2.charAt(q))>0) cnt -- ;
                map.put(s2.charAt(q),map.get(s2.charAt(q))-1);  
                }
                if(cnt!=0)
                q++;
            }
            
        }
        return false;

    }
}
