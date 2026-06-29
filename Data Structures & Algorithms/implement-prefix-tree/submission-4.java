class PrefixTree {
    Node root ;
    class Node
    {
       Node [] mapping ;
       boolean isEnd ;
       Node()
       {
        mapping = new Node[26];
        isEnd = false;
       }
    }

    public PrefixTree() {
         root = new Node();
    }

    public void insert(String word) {
        Node temp = root;
        for(char ch : word.toCharArray())
        {
            if(temp.mapping[ch-'a']==null)
            {
            Node node = new Node();
            temp.mapping[ch-'a'] = node ;
            }
            temp = temp.mapping[ch-'a'];
        }
        temp.isEnd = true ;
    }

    public boolean search(String word) {
        Node temp = root ;
        for(char ch: word.toCharArray())
        {
            if(temp.mapping[ch-'a']==null)
            return false;
            temp = temp.mapping[ch-'a'];
        }
        if(temp.isEnd==true)
        return true;
        else return false;
    }

    public boolean startsWith(String prefix) {
            Node temp = root ;
        for(char ch: prefix.toCharArray())
        {
            if(temp.mapping[ch-'a']==null)
            return false;
            temp = temp.mapping[ch-'a'];
        }
        
        return true;
    }
}
