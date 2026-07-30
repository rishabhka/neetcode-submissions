class Solution {
    class Node 
    {
        int time  ; String s ;
        Node(String s , int time)
        {
            this.s =s ; this.time = time ;
        }
    }
    public boolean match(String s,String t)
    {
        int diff = 0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)!=t.charAt(i)) diff++ ;
        }
        return diff==1?true : false;

    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashMap<String,List<String>> adjList = new HashMap<>();
        adjList.put(beginWord,new ArrayList<>());
        for(String s :wordList)
        adjList.put(s,new ArrayList<>());
        wordList.add(beginWord) ;
        for(int i=0;i<wordList.size();i++)
        {
            for(int j=i+1;j<wordList.size();j++)
            {
                if(match(wordList.get(i),wordList.get(j)))
                {
                    adjList.get(wordList.get(i)).add(wordList.get(j));
                    adjList.get(wordList.get(j)).add(wordList.get(i));
                }
            }
        }
        if(!adjList.containsKey(endWord)) return 0 ;
        Queue<Node> q = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        set.add(beginWord) ;
        q.offer(new Node(beginWord,1)) ;
        while(!q.isEmpty())
        {
            Node node = q.poll();
            if(node.s.equals(endWord)) return  node.time ;
            for(String neigh : adjList.get(node.s))
            {
                if(set.contains(neigh)) continue ;
                set.add(neigh) ;
                q.offer(new Node(neigh,node.time+1)) ;
            }
        }
        return 0 ;
    }
}
