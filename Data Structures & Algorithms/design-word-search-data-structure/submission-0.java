class WordDictionary {

    public static class  Node
    {
      Node [] alpha = new Node[26];
      boolean isEnd = false;
    }
    public Node root;

    public WordDictionary() {
    root = new Node();
    }

    public void addWord(String word) {
        Node head = root ;
        // if(root==null)
        for(int i=0;i<word.length();i++)
        {
            char letter = word.charAt(i);
            // System.out.println(letter);
            if(head.alpha[letter-'a']==null)
            {
                Node temp = new Node ();
                head.alpha[letter-'a'] = temp ;
            }
            head = head.alpha[letter-'a'];

        }
        head.isEnd = true;

    }

    public boolean f(Node current_node,int curr_indx, String word)
    {
      if(current_node.isEnd==true&&word.length()==curr_indx)
      return true;
      else if(word.length()<=curr_indx)
      return false;
      else if(word.charAt(curr_indx)=='.')
      {
        boolean rtnval =false;
        for(int i=0;i<26;i++)
        {
            if(current_node.alpha[i]!=null)
            rtnval = rtnval || f(current_node.alpha[i],curr_indx+1,word);
        }
        return rtnval;
      }
      else if(current_node.alpha[word.charAt(curr_indx)-'a']==null)
      return false;
      else return f(current_node.alpha[word.charAt(curr_indx)-'a'],curr_indx+1,word);
    //   return true;
    }

    public boolean search(String word) {
        
       return f(root,0,word);

    }
}
