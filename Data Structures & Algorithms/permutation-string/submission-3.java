class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length())
        return false ;
        int [] src = new int[26]; 
        int [] dest = new int[26]; 
        for(char ch : s1.toCharArray())
        src[ch-'a'] = src[ch-'a'] + 1;

        for(int i=0;i<s1.length();i++)
        {
            char ch = s2.charAt(i);
           dest[ch-'a'] = dest[ch-'a'] + 1; 
        }
        if(Arrays.equals(src,dest))
        return true ;

        int p= 0; int q= s1.length();

        while(q<s2.length())
        {
            char prev = s2.charAt(p);
            char next = s2.charAt(q);
            // Substract prev one and add next one
            dest[prev-'a'] = dest[prev-'a'] - 1; 
            dest[next-'a'] = dest[next-'a'] + 1; 

            if(Arrays.equals(src,dest))
            return true;

            q++;
            p++;


        }
        return false;

    }
}
