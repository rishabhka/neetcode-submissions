public class Trie 
	{
	Trie [] node ;
	boolean isEnd  ;
	Trie()
	{
	node = new Trie [26];
	isEnd = false ;
	}
	}
class WordDictionary {

	Trie root ;

    public WordDictionary() {
	 root = new Trie();
    }

    public void addWord(String word) {
	Trie temp = root ;
	// System.out.println(temp.node.length);
	for(char s : word.toCharArray())
	{
	// System.out.println(s-'a');
	if(temp.node[s-'a']==null)
	{
	 Trie newNode = new Trie();
	 temp.node[s-'a'] = newNode ;
	 temp = newNode ;
	}
	else
	temp = temp.node[s-'a'] ;
	}
	temp.isEnd= true ;
    }
	public boolean dfs(String word, int i , Trie temp)
	{
		while(i<word.length())
		{
			char newChar = word.charAt(i);
			if(newChar == '.')
			{
				for(int j=0;j<26;j++)
				{
					if(temp.node[j]!=null)
					{
					if(dfs(word,i+1,temp.node[j]))
					{
						return true ;
					}
					}
				}
                return false;
				
			}
			else if(temp.node[newChar-'a']!=null)
			{
				temp = temp.node[newChar-'a'];
				i++;
			}
			
			else return false ;
			
		}
		if(temp.isEnd)
		return true ;
	    else return false ;
		
	}

    public boolean search(String word) {
		Trie temp = root ;
		return dfs(word,0 ,temp);
}
}