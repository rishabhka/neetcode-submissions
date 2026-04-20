class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len =0 ;
        int p=0; int q =0;
        HashSet<Character> set = new HashSet<>();
        while(q<s.length())
        {
            if(set.contains(s.charAt(q)))
            {
                set.remove(s.charAt(p));
                p++;
            }
            else
            {
            set.add(s.charAt(q));
            q++;
            }
            if(len<q-p+1)
            len=q-p;
            System.out.println(s.substring(p,q));
        }
        return len ;
    }
}
