class WordDictionary {

    Node root ;
    public class Node
    {
       Node [] mapping = new Node[26]; ;
       boolean isEnd = false;
    }

    public WordDictionary() {
    root = new Node();
    }

    public void addWord(String word) {
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
    public boolean find(String word , Node temp)
    {
        for(int i=0;i<word.length();i++)
        {
            
            char ch = word.charAt(i);
            if(ch=='.')
            {
                boolean flag = false; 
                for(int j=0;j<26;j++)
                {
                    if(temp.mapping[j]!=null)
                    flag = flag || find(word.substring(i+1,word.length()),temp.mapping[j]);
                    if(flag) return true ;
                }
                return false;
            }
            else
            {
            if(temp.mapping[ch-'a']==null)
            return false;
            temp = temp.mapping[ch-'a'];
            }
        }
        if(temp.isEnd==true)
        return true;
        else return false;

    }

    public boolean search(String word) {
         Node temp = root ;
        return find(word,root);
    }
}
