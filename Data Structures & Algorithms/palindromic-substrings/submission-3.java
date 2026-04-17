class Solution {
    public int countSubstrings(String s) {
        
        int n = s.length();
        int l = 0 , r =0 ;
        int glob_i = 0 , len =0 , count =0;
        for(int i=0;i<n;i++)
        {
            l = i ;
            r = i ;
            while(l>=0&&r<n&&s.charAt(l)==s.charAt(r))
            {
                count ++;
                l-- ;
                r ++ ;
            }
            l = i ;
            r = i+1 ;
            while(l>=0&&r<n&&s.charAt(l)==s.charAt(r))
            {
                count ++;
                l-- ;
                r ++ ;
            }
            
        }
        return count;
    }
}
