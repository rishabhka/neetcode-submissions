class Solution {
    public String mergeAlternately(String word1, String word2) {
        String s = "" ;
        int p =0; int q=0;
        while(p<word1.length()&& q<word2.length())
        {
            s= s+word1.charAt(p)+word2.charAt(q);
            p++ ;
            q++;
        }
        if(p<word1.length())
        s= s + word1.substring(p,word1.length());

        if(q<word2.length())
        s= s + word2.substring(q,word2.length());

        return s;
    }
}