class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.equals(""))
        return 0;
        HashSet<Character> set = new HashSet<>();
        int p=0; int q =1; int max_len =1 ;
        set.add(s.charAt(0));
        int len =1 ;
        int i=0;
        for(int j=1;j<s.length();j++)
        {
            while(set.contains(s.charAt(j)))
            {
            set.remove(s.charAt(i)) ;
            i++;
            }
            set.add(s.charAt(j));
            if((j-i+1)>max_len)
            max_len=j-i+1;
            
        }
        return max_len;
    }
}
