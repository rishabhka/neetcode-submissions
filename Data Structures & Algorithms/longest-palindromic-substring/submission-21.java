class Solution {
    public String explandAlongEven(String s,int i) 
    {
        int j = i + 1;
        if(j<s.length()&&s.charAt(i)!=s.charAt(j))
        return s.substring(i,j) ;
        while(i>=0&&j<s.length())
        {
            if(s.charAt(i)!=s.charAt(j))
            break ;
            i--;
            j++;
        }
    return s.substring(i+1,j) ;
    }
    public String explandAlongOdd(String s,int i) 
    {
        int j = i + 1 ;
        i = i - 1 ;
        int len = 0 ;
        while(i>=0&&j<s.length())
        {
            if(s.charAt(i)!=s.charAt(j))
            break ;
            i--;
            j++;
        }
        System.out.println(i+" "+j) ;
    return s.substring(i+1,j) ;
    }
    public String longestPalindrome(String s) {
        int n = s.length() ;  String max = "" ;
        for(int i = 0;i<n;i++)
        {
        String temp = explandAlongEven(s,i) ;
        if(temp.length()>max.length()) max = temp ;

        temp = explandAlongOdd(s,i) ;
        if(temp.length()>max.length()) max = temp ;
        }
        return max ;
    }
}
