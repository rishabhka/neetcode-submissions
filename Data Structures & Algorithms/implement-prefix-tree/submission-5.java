class PrefixTree {
    class Trie
    {
        Trie [] neigh ; boolean isEnd = false;
        Trie() {neigh = new Trie [26]; } 
    }
    Trie root ;
    public PrefixTree() {
         root = new Trie();
    }

    public void insert(String word) {
        Trie temp = root ;
        for(int i=0;i<word.length();i++)
        {
            if(temp.neigh[(word.charAt(i)-'a')]==null)
            {
                Trie node = new Trie();
                temp.neigh[word.charAt(i)-'a'] = node ;
            }
            temp = temp.neigh[word.charAt(i)-'a'] ; 
        }
        temp.isEnd = true ;
    }

    public boolean search(String word) {
        Trie temp = root ;
        for(int i=0;i<word.length();i++)
        {
            if(temp.neigh[(word.charAt(i)-'a')]==null) return false;
            else temp = temp.neigh[word.charAt(i)-'a'] ; 
        }
        if(temp.isEnd == true) return true ;
        else return false;
    }

    public boolean startsWith(String word) {
        Trie temp = root ;
        for(int i=0;i<word.length();i++)
        {
            if(temp.neigh[(word.charAt(i)-'a')]==null) return false;
            else temp = temp.neigh[word.charAt(i)-'a'] ; 
        }
        return true;
    }
}
