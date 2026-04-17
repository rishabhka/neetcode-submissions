class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if(n<=1)
        return s ;
        
        int max_len = 1;
        int start = 0;
        for (int i = 0; i < n; i++) {
        int j=i-1 ; int k = i+1; int count =1 ;
        while(j>=0&&k<=n-1 && s.charAt(k)==s.charAt(j))
        {
            count = count + 2;
            if(count>max_len)
            {
            max_len= count ;
            start = j;
            }
             j--;
             k++;

        }
        j=i ; k = i+1; count =0 ;
        while(j>=0&&k<=n-1 && s.charAt(k)==s.charAt(j))
        {
            count = count + 2;
            if(count>max_len)
            {
            max_len= count ;
            start = j;
            }
             j--;
             k++;

        }
        }
        return s.substring(start,start+max_len) ;
    }
}
