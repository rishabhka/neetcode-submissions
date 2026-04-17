class PrefixTree {

    Node root ;
    
    public class Node
    {
    char alpha ;
    Node [] letter  = new Node [26] ;
    boolean isEnd = false ;
    }

    public void insert(String word) {
        Node next = root;
        if(root==null)
        {
            Node letter = new Node() ;
            next = letter ;
            root = letter ;
        }
        int i= 0;
        while(i<=word.length()-1)
        {
            if(next.letter[word.charAt(i)-'a']==null)
            {
            Node temp = new Node() ;
            temp.alpha = word.charAt(i) ;
            next.letter[word.charAt(i)-'a'] = temp ;
            }
            next = next.letter[word.charAt(i)-'a'] ;
            i++;
        }
        next.isEnd = true;

    }

    public boolean search(String word) {
        int i=0;
        Node start = root ;
        if(root==null)
        return false;
        while(i<=word.length()-1)
        {
            char x = word.charAt(i) ;
            if(start.letter[x-'a']!=null)
            {
            i++;
            start = start.letter[x-'a'];
            } else return false;

        }
        if(i==word.length()&&start.isEnd==true)
        return true ;
        else
        return false;

    }

    public boolean startsWith(String prefix) {

        int i=0;
        Node start = root ;
        if(root==null)
        return false;
        while(i<=prefix.length()-1)
        {
            char x = prefix.charAt(i) ;
            if(start.letter[x-'a']!=null)
            {
            i++;
            start = start.letter[x-'a'];
            } else return false;

        }
        return true ;
        

    }
}
