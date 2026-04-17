class PrefixTree {

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
	
	Trie root ;

    public PrefixTree() {
       root = new Trie();  
    }

    public void insert(String word) {
	
	Trie temp = root ;
	System.out.println(temp.node.length);
	for(char s : word.toCharArray())
	{
	System.out.println(s-'a');
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

    public boolean search(String word) {
	
	Trie temp = root ;
		for(char s :word.toCharArray())
		{
			if(temp.node[s-'a']==null)
				return false ;
			else
				temp = temp.node[s-'a'] ; 	
		}
		if(temp.isEnd)
			return true ;
		else return false ;

    }

    public boolean startsWith(String prefix) {
	
	Trie temp = root ;
	for(char s : prefix.toCharArray())
	{
	if(temp.node[s-'a'] == null )
	return false ;
	else 
	temp = temp.node[s-'a'] ;
	}
	return true ;
	

    }
}