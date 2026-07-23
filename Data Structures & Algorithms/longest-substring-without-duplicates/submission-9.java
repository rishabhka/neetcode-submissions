class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.equals("")) return 0;
        HashSet<Character> set = new HashSet<>();
        int max = Integer.MIN_VALUE ;
        int p =0 ;
        int q =0; 
        while(q<s.length())
        {
            if(!set.contains(s.charAt(q)))
            {
                set.add(s.charAt(q));
                if(max<q-p+1)
                max = q-p+1 ;
                q++;
            }
            else
            {
                set.remove(s.charAt(p)) ;
                p ++ ;
            }
        }
        return max ;
    }
}
