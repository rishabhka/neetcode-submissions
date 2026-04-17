class Solution {
    public boolean sub(char [] s,int i,int j,int k)
    {
        if(i>=j)
        return true ;
        else
        {
            if(s[i]==s[j])
            return sub(s,i+1,j-1,k);
            else
            {
                if(k>0)
                return sub(s,i+1,j,k-1) || sub(s,i,j-1,k-1) ;
                else return false ;
            }         
        }
    }
    public boolean validPalindrome(String s) {
        char [] charAr = s.toCharArray();
        int j = s.length()-1;
        int i=0;
        return sub(charAr,i,j,1);
        // boolean flag = false ;
        // while(i<j)
        // {
        //     if(s.charAt(i)!=s.charAt(j))
        //     {
        //         if(flag)
        //         return false ;
        //         else
        //         {
        //         j-- ;
        //         flag = true ;
        //         continue ;
        //         }
        //     }
        //     i++;
        //     j--;
        // }
        // return true ;
        
    }
}