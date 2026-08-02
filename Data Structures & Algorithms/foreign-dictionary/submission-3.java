class Solution {

    public String foreignDictionary(String[] words) {
      HashMap<Character ,ArrayList<Character> >  adjList = new HashMap<>(); 
      for(String word:words)
      {
        for(char ch :word.toCharArray())
        adjList.putIfAbsent(ch,new ArrayList<>());
      }
      int [] indegree = new int [26] ;
      for(int i=1;i<words.length;i++)
      {
        int min = Math.min(words[i-1].length(), words[i].length());
        int j=0;
        while(j<min&&(words[i-1].charAt(j)==words[i].charAt(j)))
        {
            j++;
        }
        if(j == min)
        {
        if ( words[i-1].length() > words[i].length()) return "";
        }
        else
        {
        adjList.get(words[i-1].charAt(j)).add(words[i].charAt(j)) ;
        indegree[words[i].charAt(j)-'a'] ++ ;
        }
      }
      Queue<Character> q = new LinkedList<>();
      for(int i=0;i<indegree.length;i++)
      {
        if(adjList.containsKey((char)(i+'a'))&&indegree[i]==0)
        q.add((char)(i+'a')) ;
      }
      StringBuilder res = new StringBuilder();
      while(!q.isEmpty())
      {
        char node = q.poll();
        res.append(node);
        for(char neigh : adjList.get(node) )
        {
            indegree[neigh-'a']--;
            if(indegree[neigh-'a']==0) q.offer(neigh) ;
        }
      }
      return res.length() == adjList.size() ? res.toString() : "";

    }
}
