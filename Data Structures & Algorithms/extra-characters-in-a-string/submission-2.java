class Solution {
    public class Trie 
	{
	Trie [] node ;
	Boolean isEnd ;
	
	Trie()
	{
	node = new Trie [26] ;
	isEnd = false;
	}
	public void insert(String s , Trie root)
	{
	Trie temp = root ;
	for(char c : s.toCharArray())
	{
	if(temp.node[c-'a'] == null)
	{
	Trie newNode = new Trie();
	temp.node[c-'a'] = newNode ;
	temp = newNode ;
	}
	else temp = temp.node[c-'a'] ;
	}
    temp.isEnd = true;
	}
	public boolean search(String word,Trie root) {
	
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
}
public int f(String s , Trie root , int i ,int dp [])
{
	if(s==null||i>=s.length()) return 0;
    else if(dp[i]!=-1)
    return dp[i] ;
	
	else{
		int x= Integer.MAX_VALUE;
		int y =0;
        for(int j=i;j<s.length();j++)
        {
		if(root.search(s.substring(i,j+1),root))
		x= Math.min(x,f(s,root,j+1, dp));  
        }
	    y = f(s,root,i+1,dp)+1;  // skip it 

        dp[i] = Math.min(x,y);
        return dp[i];
	}
	
	
}
    public int minExtraChar(String s, String[] dictionary) {
        Trie root = new Trie();
		for(String str : dictionary)
		{
		root.insert(str,root);
		}
		int dp [] = new int [s.length()] ;
        Arrays.fill(dp,-1);
		return f(s,root,0,dp);
		
    }
}