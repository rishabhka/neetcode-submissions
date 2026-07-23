class Solution {
    public int characterReplacement(String s, int k) {
        int p =0; int q = 0 ;
        HashMap<Character,Integer> map = new HashMap<>(); 
        int max_freq = 0 ; int max_len = Integer.MIN_VALUE ;
        while(q<s.length())
        {
            map.put(s.charAt(q),map.getOrDefault(s.charAt(q),0)+1);
            max_freq = Math.max(max_freq,map.get(s.charAt(q))) ;
            if((q-p+1)-max_freq<=k)
            max_len = Math.max(max_len,q-p+1);
            else
            {
                while(p<q&&(q-p+1)-max_freq>k)
                {
                    map.put(s.charAt(p),map.get(s.charAt(p))-1);
                    p++;
                }
            }
            q++;
            
        }
        return max_len ;
    }
}
