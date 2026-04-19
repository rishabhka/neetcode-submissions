class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int len = beginWord.length();
        if(beginWord.equals(endWord)|| (!wordList.contains(endWord)))
        return 0;
        HashMap<Integer,String> map= new HashMap<>();
        List<List<Integer>> adjList = new ArrayList<>();

        for(int i=0;i<wordList.size();i++)
        {
            map.put(i,wordList.get(i));
            adjList.add(new ArrayList<>());
        }
        // Add edges if one char differ
        Queue<int []> q =new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<wordList.size();i++)
        {
            int diff1=0;
            for(int j=i+1;j<wordList.size();j++)
        {
            int diff =0;
            for(int k=0;k<len;k++)
            {
                if(wordList.get(i).charAt(k)!=wordList.get(j).charAt(k))
                diff ++;
            }
            if(diff==1)
            {
                adjList.get(i).add(j);
                adjList.get(j).add(i);
            }
        }
        // Add in queue all teh nodes which differ from start by 1
        for(int k=0;k<len;k++)
            {
                if(wordList.get(i).charAt(k)!=beginWord.charAt(k))
                diff1 ++;
            }
            if(diff1==1)
            {
                q.add(new int [] {i,2});
            }
        }
        int max =0;
        while(!q.isEmpty())
        {
            int [] pl = q.poll();
            int node = pl[0];
            if(map.get(node).equals(endWord))
            return pl[1] ;
            for(int i=0;i<adjList.get(node).size();i++)
            {
                int neigh = adjList.get(node).get(i);
                
                if(set.contains(neigh))
                continue ;
                set.add(neigh);
                q.offer(new int []{neigh,pl[1]+1})   ;      
            }
        }
        return max ;

    }
}
