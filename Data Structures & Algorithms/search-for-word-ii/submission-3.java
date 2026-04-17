class Solution {
    Node root ;
    //Node head ;
    public class Node
    {
      Node [] alpha = new Node [26] ;
      boolean isEnd = false ;
      String word = "";
    }
    public Solution()
    {
        root = new Node();
    }
    public void trieInsert(String word)
    {
        Node head = root ;
        int n= word.length();
        for(int i=0;i<n;i++)
        {
        char currentChar = word.charAt(i);
        if(head.alpha[currentChar-'a']==null)
        {
            Node temp = new Node();
            //temp.isPresent = true;
            head.alpha[currentChar-'a'] = temp;
        }
        head = head.alpha[currentChar-'a'];
        }
        head.isEnd = true ;
        head.word = word;
    }
    

    public boolean recur(char[][] board,boolean [][] visited,int i,int j,int n,int m,Node head,
    List<String> result)
    {
      if(i<0||i>=n||j<0||j>=m||visited[i][j])
      return false;

      int x = board[i][j] - 'a' ;
      if(head.alpha[x]==null)
      return false;

      boolean flag = false;

      head = head.alpha[x];

      if(head.isEnd==true&& head.word!=null)
      {
        result.add(head.word);
        head.word = null;
      }
      
      visited[i][j] = true ;

      flag = recur(board,visited,i+1,j,n,m,head,result)
        || recur(board,visited,i,j+1,n,m,head,result) || recur(board,visited,i-1,j,n,m,head,result)
        || recur(board,visited,i,j-1,n,m,head,result) ;

        visited[i][j] = false;
    return flag ;
    }
    public List<String> findWords(char[][] board, String[] words) {
        int n = board.length;
        int m = board[0].length;
        List<String> result = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        
        for(int k=0;k<words.length;k++)
        {
         trieInsert(words[k]);
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                //head = root;
                boolean [][] visited = new boolean [n][m];
                if(recur(board,visited,i,j,n,m,root,result))
                System.out.println("added");
                //set.add(words[k]);
            }
        }
        return result ;
    }
}
