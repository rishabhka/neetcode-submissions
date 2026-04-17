class Solution {
    int count =0;
    public void f(String s, int i , int prev)
    {

    int prev_int = Integer.parseInt(s.substring(prev,i));
        if(prev_int<0||prev_int>26)
        return ;
        if(prev_int==0)
        return ;
        if(i>=s.length())
        {
           count ++;
           return ;
        }
        
        else
        {
            f(s,i+1,i)  ;
            f(s,i+1,prev) ;
            return ;
        }

    }
    public int numDecodings(String s) {
        if(s.length()==0
        ||s.charAt(0)=='0')
        return 0 ;
        f( s,  1,  0 ) ;
        return count ;
    }
}
