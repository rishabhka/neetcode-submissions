class Solution {
    public boolean isPalindrome(String s) {

       
        String str = "";
       for(char c :s.toCharArray())
       {
        if((c-'a'>=0&&c-'a'<26)||(c-'A'>=0&&c-'A'<26)||(c-'0'>=0&&c-'0'<=9))
        str = str + c ;
       }
       int p = 0;
       int q = str.length()-1;

       while(p<=q)
       {
        if(Character.toLowerCase(str.charAt(p))!=Character.toLowerCase(str.charAt(q)))
        return false;
        p++;
        q--;
       } 
       return true ;
    }
}
