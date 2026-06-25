class Solution {
    public int characterReplacement(String s, int k) {
        int p =0; int q = 0; int len =0; int max_char =0;
        HashMap<Character,Integer> map = new HashMap<>();
        while(q<s.length())
        {
            map.put(s.charAt(q),map.getOrDefault(s.charAt(q),0)+1);
            if(map.get(s.charAt(q))>max_char) 
            max_char = map.get(s.charAt(q));
            
            if((q-p+1)-max_char>k)
            {
                if(map.get(s.charAt(p))==max_char)
                max_char--;
                map.put(s.charAt(p),map.get(s.charAt(p))-1);
                p++;
                if(map.get(s.charAt(p))>max_char) 
                max_char = map.get(s.charAt(p));
            }
            else
            {
            if(q-p+1>len)
            len = q-p+1;
            
            }

            q++;
            



            


        }
        return len;
    }
}
