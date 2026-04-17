class Solution {
    public boolean f(String s1,String s2,String s3,int i,int j)
    {
        if(i+j==s3.length())
        return true ;
        // else if(Math.abs(i-j)>1)
        // return false ;
        // else if(i==s1.length&&j==s2.length)
        // return false ;
        else
        {
            boolean x = false , y = false ;
            if(i<s1.length())
            {
            if(s1.charAt(i)==s3.charAt(i+j))
            x = f( s1, s2, s3, i+1, j);
            }
            if(j<s2.length())
            {
            if(s2.charAt(j)==s3.charAt(i+j))
            y = f( s1, s2, s3, i, j+1);
            }
            return x||y ;
        }

    }
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length()!=s3.length())
        return false ;
        else return f(s1,s2,s3,0,0);
    }
}
