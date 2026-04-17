class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if(n==0||n==1)
        return s ;
        if(n==2)
        {
            if(s.charAt(0)==s.charAt(1))
            return s ;
        else return s.substring(0,1);
        }
        

        int max_len = 0;
        int start = 0;
        for(int i=0;i<s.length();i++) // This is for odd length
        {
            int count = 1;
            int j=i-1 ; int k = i+1;
            while(j>=0&&k<=n-1)
            {
                
                if(s.charAt(k)==s.charAt(j))
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
                else break;
            }
            
        }
        for(int i=0;i<s.length();i++) // This is for even length
        {
            int count = 0;
            int j=i ; int k = i+1;
            while(j>=0&&k<=n-1)
            {
                
                if(s.charAt(k)==s.charAt(j))
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
                else break;
            }
            
        }
        System.out.println(start+" "+max_len);
        return s.substring(start,start+max_len) ;
    }
}
