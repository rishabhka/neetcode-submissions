class Solution {
    int min_len = Integer.MAX_VALUE;
    public class Node
    {
        int vertex ;
        String str ;
        List<Integer> adjList ;
        Node(int vertex,String str)
        {
            this.vertex = vertex ;
            this.str = str ;
            adjList = new ArrayList<>();
        }
    }
   public boolean diff(String word2,String word1)
   {
    int k =0;
    for(int i=0;i<word1.length();i++)
    {
        if(word1.charAt(i)!=word2.charAt(i))
        k++;
    }
    return k==1;
   }
   public void dfs(List<Node> list,String beginWord,String endWord,int l,int [] visited,int j)
   {
    if (l >= min_len) return;
    
    if(beginWord.equals(endWord))
    {
        if(l<min_len)
        min_len =l;
    }
    if(visited[j]==1)
    return ;
    visited[j] = 1;
    
    for(int i=0;i<list.get(j).adjList.size();i++)
    {
        int next = list.get(j).adjList.get(i) ;
        String curr_word = list.get(next).str;
        dfs(list,curr_word,endWord,l+1,visited,next);
    }
    visited[j] = 0;

   }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        wordList.add(beginWord);
        int n = wordList.size();
        if(!wordList.contains(endWord))
        return 0;
        List<Node> list = new ArrayList<>();

        for(int i=0;i<wordList.size();i++)
        {
            Node node = new Node(i,wordList.get(i));
            list.add(node);
        }
        for(int i=0;i<n;i++)
        {
            String curr_word = wordList.get(i);
            for(int j=0;j<n;j++)
            {
                if(j!=i&&diff(curr_word,wordList.get(j)))
                {
                 Node nodei = list.get(i);
                 Node nodej =list.get(j);
                 nodei.adjList.add(j);
                 nodej.adjList.add(i);
                }
            }
        }
        int [] visited = new int [list.size()]; 
        dfs(list,beginWord,endWord,1,visited, wordList.size()-1) ;
        return min_len==Integer.MAX_VALUE ? 0 : min_len;
    }
}
