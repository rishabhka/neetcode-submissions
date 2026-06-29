class Solution {
    public static boolean differByOne(String a,String b)
    {
        int count =0;
        for(int i=0;i<a.length();i++)
        {
            if(a.charAt(i)!=b.charAt(i))
            count++;
            if(count>1)
            return false;

        }
        return true;
    }
    public class Node 
    {
        String s;
        int time;
        Node(String s, int time)
        {
            this.s = s;
            this.time = time;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        boolean isbegin = false; boolean isEnd = false;
        for(int i=0;i<wordList.size();i++)
        {
            if(wordList.get(i).equals(endWord))
            isEnd=true ;
            if(wordList.get(i).equals(beginWord))
            isbegin=true ;
        }
        if(!isbegin) wordList.add(beginWord) ;
        if(!isEnd) return 0 ;
        HashMap<String,List<String>> adjList = new HashMap<>();
        for(int i=0;i<wordList.size();i++)
        {
            adjList.put(wordList.get(i),new ArrayList<>());
        }
        for(int i=0;i<wordList.size();i++)
        {
            for(int j=i;j<wordList.size();j++)
        {
            if(differByOne(wordList.get(i),wordList.get(j)))
            {
                adjList.get(wordList.get(i)).add(wordList.get(j));
                adjList.get(wordList.get(j)).add(wordList.get(i));
            }

        }
        }
        HashSet<String> visited = new HashSet<>();
        // dfs(beginWord,endWord,adjList,0,visited);
        Queue<Node> q = new LinkedList<>();
        
        q.add(new Node(beginWord,0)) ; 
        while(!q.isEmpty())
        {
            Node node = q.poll();
            visited.add(node.s);
            for(String neigh : adjList.get(node.s) )
            {
                if(neigh.equals(endWord)) return node.time+2 ;
                if(!visited.contains(neigh))
                {
                    q.add(new Node(neigh,node.time+1));
                }
            }
            
        }
        
        
        return 0;
    }
}
