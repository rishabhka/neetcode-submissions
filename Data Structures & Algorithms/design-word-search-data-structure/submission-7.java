class WordDictionary {
    public class Trie
    {
        Trie [] neigh ; boolean isEnd = false;
        Trie() { neigh = new Trie[26] ;}
    }
    Trie root ;
    public WordDictionary() {
        root = new Trie();
    }

    public void addWord(String word) {
        Trie  temp = root;
        for(char ch : word.toCharArray())
        {
            if(temp.neigh[ch-'a']==null)
            {
                Trie node = new Trie();
                temp.neigh[ch-'a'] = node ;
            }
            temp = temp.neigh[ch-'a'] ;
        }
        temp.isEnd = true ;
    }
    public boolean dfs(String word,Trie sub)
    {
        Trie  temp = sub;
        for(int j=0;j<word.length();j++)
        {
            char ch = word.charAt(j) ;
            if(ch=='.')
            {
                for(int i=0;i<26;i++)
                {
                    if(temp.neigh[i]==null) continue ;
                    if(dfs(word.substring(j+1,word.length()),temp.neigh[i])) 
                    return true ;                    
                }
                return false;
            }
            else if(temp.neigh[ch-'a']==null) return false;
            else
            temp = temp.neigh[ch-'a'] ;
        }
        if(temp.isEnd==true) return true ;
        else return false; 
    }
    public boolean search(String word) {
        return dfs(word,root) ;
    }
}
