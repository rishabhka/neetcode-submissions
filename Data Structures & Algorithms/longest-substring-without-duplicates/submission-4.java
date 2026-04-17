class Solution {
    
    public int lengthOfLongestSubstring(String s) {
        int max = 0 ;
        HashSet<Character> set = new HashSet<>();
        int p=0; int q =0; int curr =0;
        while(q<s.length())
        {
            while(set.contains(s.charAt(q)))
            {
                set.remove(s.charAt(p)) ;
                p++;
                curr --;
            }
            curr ++;
            if(curr>max)
            max = curr ;
            set.add(s.charAt(q)) ;
            q++;
            
        }
        return max ;
    }
}
