class Solution {
    public int f(String word1, String word2,int m,int n,int i , int j)
    {
        if(i==m)
        return n-j;
        else if(j==n)
        return m-i;
        else
        {
            // System.out.println(word1.substring(i,m)+" "+word2.substring(j,n));
            if(word1.charAt(i)==word2.charAt(j))
            return f(word1, word2,m,n,i+1 ,j+1);
            else
            {
                return Math.min(Math.min(f(word1,word2,m,n,i+1,j),f(word1,word2,m,n,i+1,j+1)),f(word1,word2,m,n,i,j+1)) +1; 
            }
        }
        

    }
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        if(word1.equals(word2))
        return 0 ;
        else return f(word1,word2,m,n,0,0);
    }
}
