class Solution {
    public class Trie
    {
        char c ;
        Trie [] child ;
        int count ;
        boolean isEnd ;
        Trie(char c)
        {
            this.c = c ;
            child = new Trie[26] ;
            count = 0;
            isEnd = false;
        }
    
    }
    public void insert(String s,Trie root)
    {
        for(int i=0;i<s.length();i++)
        {
        // if(root==null) return ;
        if(root.child[s.charAt(i)-'a']==null)
        root.child[s.charAt(i)-'a'] = new Trie(s.charAt(i)) ;
        root = root.child[s.charAt(i)-'a'] ;
        root.count ++ ;
        }
        root.isEnd = true ;
    }
    public int check(String s,Trie root,int len)
    {
        int x =0 ;
        for(int i=0;i<s.length();i++)
        {
            if(root.isEnd==true)
            return x ;
            Trie curr = root.child[s.charAt(i)-'a'] ;
            if (curr == null || curr.count < len)
            return x;
            else root = curr ;
            x++;
        }
        return x; 

    }
    
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length ;
        if(n==1) return strs[0] ;
        Trie root = new Trie('/');
        for(int i=0;i<strs.length;i++)
        {
            insert(strs[i],root);
        }
        int x =  check(strs[0],root,n);
        System.out.println(x);
        return strs[0].substring(0,x);
    }
}