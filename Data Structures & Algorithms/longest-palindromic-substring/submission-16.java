class Solution {
    
    public String longestPalindrome(String s) {
        
        String result = "";
        if(s.length()>0)
        result=""+s.charAt(0);
        for(int i=0;i<s.length();i++)
        {
        char ch = s.charAt(i); 
        int prev =i-1; int next = i+1; //odd len
        while(prev>=0&&next<s.length()&&(s.charAt(prev)==s.charAt(next)))
        {
            if(s.substring(prev,next+1).length()>result.length())
            result=s.substring(prev,next+1);
            prev--;
            next ++;
        }
         prev =i; next  = i+1; //even len
        while(prev>=0&&next<s.length()&&(s.charAt(prev)==s.charAt(next)))
        {
            if(s.substring(prev,next+1).length()>result.length())
            result=s.substring(prev,next+1);
            prev--;
            next ++;
        }
        
    }
    return result;
}
}
