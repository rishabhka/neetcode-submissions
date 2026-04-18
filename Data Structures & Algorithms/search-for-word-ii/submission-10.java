
class Solution {
    class Trie
{
    Trie [] child ;
    boolean isEnd ;
    Trie()
    {
        child = new Trie [26];
        isEnd = false;

    }
    public void insert(String word)
    {
        if(root == null)
        root = new Trie();

        Trie temp = root;

        for(char x :word.toCharArray())
        {
            if(temp.child[x-'a']==null)
            temp.child[x-'a'] = new Trie();
            temp = temp.child[x-'a'] ;
        }
        temp.isEnd = true ;

    }
}
public void dfs(char [][] board,int i,int j,Trie root,String s,boolean [][] visited)
{
    if(i<0||j<0||i>=board.length||j>=board[0].length)
    return ;
    else if (visited[i][j])
    return ;
    Trie temp = root.child[board[i][j] - 'a'];
    if (temp == null) return;
    s = s + board[i][j];
    if(temp.isEnd == true)
    {
        result.add(new String(s));
        temp.isEnd = false;
    }
    
        visited[i][j]=true;
            dfs(board,i+1,j,temp,s,visited) ;
            dfs(board,i,j+1,temp,s,visited) ;
            dfs(board,i-1,j,temp,s,visited) ;
            dfs(board,i,j-1,temp,s,visited) ;
        visited[i][j]=false;
        return ;

}
    Trie root ;
    List<String> result = new ArrayList<>();
    public List<String> findWords(char[][] board, String[] words) {
        root = new Trie();
        
        for(String word:words)
        {
            root.insert(word);
        }
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                boolean [][] visited = new boolean[board.length][board[0].length] ;
                int x = board[i][j] -'a' ;
                if(root.child[x]==null)
                continue ;
                else
                dfs(board,i,j,root,"",visited);

            }
        }
        return result ;
    }
}
