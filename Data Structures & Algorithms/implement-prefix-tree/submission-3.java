class PrefixTree {
    PrefixTree root ;

    PrefixTree [] child ;
    boolean isEnd ;
    public PrefixTree() {
         child = new PrefixTree[26] ;
         isEnd = false;
    }

    public void insert(String word) {
        if(root==null)
        root = new PrefixTree() ;

        PrefixTree temp = root;
        int t =0;
        while(t<word.length())
        {
            char letter = word.charAt(t);
            if(temp.child[letter-'a']==null)
            {
                temp.child[letter-'a'] = new PrefixTree();
            }
            temp = temp.child[letter-'a'] ;
            t++;
        }
        temp.isEnd = true ;
    }

    public boolean search(String word) {
        PrefixTree temp = root ;
        int t =0;
        if(temp==null)
        return false ;
        while(t<word.length())
        {
            char letter = word.charAt(t) ;
            if(temp.child[letter-'a']==null)
            return false ;
            else temp = temp.child[letter-'a'] ;
            t++;
        }
        if(temp.isEnd == true)
        return true ;
        else return false;
    }

    public boolean startsWith(String word) {
        PrefixTree temp = root ;
        int t =0;
        if(temp==null)
        return false ;
        while(t<word.length())
        {
            char letter = word.charAt(t) ;
            if(temp.child[letter-'a']==null)
            return false ;
            else temp = temp.child[letter-'a'] ;
            t++;
        }
        return true ;
    }
}
