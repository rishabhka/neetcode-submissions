class Solution {
    public boolean match(String s,String p,int i,int j)
    {
        if(j==p.length()) return s.length()==i ;
        else if(s.length()==i) {
            if(j+1<p.length()&&p.charAt(j+1)=='*') return match(s,p,i,j+2) ;
            else return false;
        }
        else if(j+1<p.length()&&p.charAt(j+1)=='*')
        {
            if(s.charAt(i)==p.charAt(j)||p.charAt(j)=='.')
            return match(s,p,i+1,j) || match(s,p,i,j+2) ;
            else
            return match(s,p,i,j+2) ;
        }    
        else
        {
            if(s.charAt(i)==p.charAt(j)||p.charAt(j)=='.')
            return match(s,p,i+1,j+1) ;
            else return false ;
        }
    }
    public boolean isMatch(String s, String p) {
        return match(s,p,0,0) ;
    }
}
