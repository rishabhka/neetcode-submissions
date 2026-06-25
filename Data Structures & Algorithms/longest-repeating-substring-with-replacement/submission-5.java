class Solution {
    public int characterReplacement(String s, int k) {
        int p =0; int q = 0; int len =0; int max_char =0;
        HashMap<Character,Integer> map = new HashMap<>();
        while(q<s.length())
        {
            map.put(s.charAt(q),map.getOrDefault(s.charAt(q),0)+1);
            max_char = Math.max(map.get(s.charAt(q)),max_char);
            
            if((q-p+1)-max_char>k)
            {
                map.put(s.charAt(p),map.get(s.charAt(p))-1);
                p++;
            }
            if(q-p+1>len)
            len = q-p+1;

            q++;
            



            


        }
        return len;
    }
}
