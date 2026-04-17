class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character  > set = new HashSet<>();
		int n = s.length() ;
		if(n==0||n==1)
		return n;
		int i =0 ;
		int j = 0 ; int len =0 ; int glob_len = Integer.MIN_VALUE ;
        while(j<n)
        {
            while(i<n&&set.contains(s.charAt(j))) // delete till u find the key
			{
			set.remove(s.charAt(i)) ;
			i++ ;
			len -- ;
			}
			
			while(j<n&&!set.contains(s.charAt(j)))
			{
			set.add(s.charAt(j)) ;
			j++;
			len ++;
			}
			
			if(len>glob_len)
			glob_len = len ;
            

        }
		return glob_len ;
    }
}