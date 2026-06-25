class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> freq = new HashMap<>();
        for(char ch:t.toCharArray())
        {
        freq.put(ch,freq.getOrDefault(ch,0)+1);
        }
        String result = ""; int result_len =Integer.MAX_VALUE;
        int i=0; int j=0; int len = t.length();
        while(j<s.length())
        {
            char ch = s.charAt(j);
if (freq.containsKey(ch)) {
    if (freq.get(ch) > 0) len--;      // was still needed
    freq.put(ch, freq.get(ch) - 1);   // decrement regardless, can go negative
}
            while(len==0)
            {
                if(result_len>(j-i+1))
                {
                result_len=j-i+1;
                result = s.substring(i,j+1);
                }
                char startChar = s.charAt(i);
                if (freq.containsKey(startChar)) {
        freq.put(startChar, freq.get(startChar) + 1);
        if (freq.get(startChar) > 0) len++;   // only if we gave back a NEEDED char
    }
                
                i++;
            }
            j++;
        }
        return result ;
    }
}
