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

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        if (!wordList.contains(beginWord))
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
        Queue <Integer> q1 = new LinkedList<>();
        Queue <Integer> q2 = new LinkedList<>();
        int start = wordList.indexOf(beginWord);
        q1.add(start);
        int len =1;
        visited[start]=1;
        while(!q1.isEmpty() )
        {
            while(!q1.isEmpty())
            {
            int node = q1.poll();       
            // visited[node]=1 ;
            for(int i= 0;i<list.get(node).adjList.size();i++)
            {
                
                int curr_node = list.get(node).adjList.get(i);
                if (visited[curr_node] == 1) continue;
                String curr_s = list.get(curr_node).str ;
                if((curr_s).equals(endWord))
                return len +1;
                if(visited[curr_node]==0)
                {
                visited[curr_node]=1 ;  
                q2.add(curr_node) ;
                }
            }
            }
            len ++;

            Queue<Integer> temp = new LinkedList<>(q1);
            q1=q2;
            q2=temp;        
            
        }
        //dfs(list,beginWord,endWord,1,visited, wordList.size()-1) ;
        return 0;
    }
}
