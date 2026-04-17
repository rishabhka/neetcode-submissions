class Solution {
    public boolean isPalindrome(String s) {
        String cleanS = s.trim().replace(" ","").toLowerCase()
        .replaceAll("[^A-Za-z0-9]","");
        int n = cleanS.length();
        if(n==0||n==1)
        return true;
        int p =0;
        int q = n-1;
        while(p<=q)
        {
            if(cleanS.charAt(p)!=cleanS.charAt(q))
            return false;
            p++;
            q--;
        }
        return true;
    }
}
