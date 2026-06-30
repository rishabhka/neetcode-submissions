class Solution {
    public String foreignDictionary(String[] words) {
      HashMap<Character,List<Character>> adjList = new HashMap<>();
      int [] indegree = new int [26];
      Arrays.fill(indegree,-1);
      for(String word: words)
      {
        for(char ch :word.toCharArray())
        {
        if(!adjList.containsKey(ch))
        adjList.put(ch,new ArrayList<>());
        indegree[ch-'a']=0;
        }
      }
      
      for(int i=0;i<words.length-1;i++)
      {
        String word1 = words[i];
        String word2 = words[i+1]; int k=0;
        if(word1.startsWith(word2)&&word1.length()!=word2.length()) return "";
        while(k<word1.length()&& k<word2.length())
        {
        if(word1.charAt(k)!=word2.charAt(k))
        {
        adjList.get(word1.charAt(k)).add(word2.charAt(k));
        indegree[word2.charAt(k)-'a'] = indegree[word2.charAt(k)-'a']+1;
        break;
        }
        k++;
        }
      }
      Queue<Integer> q= new LinkedList<>();
      for(int i=0;i<26;i++)
      if(indegree[i]==0) q.offer(i);
      String result ="";
      while(!q.isEmpty())
      {
        int node = q.poll();
        result = result + (char)(node+'a');
        for(int i=0;i<adjList.get((char)(node+'a')).size();i++)
        {
            char neigh = adjList.get((char)(node+'a')).get(i);
            indegree[neigh-'a']--;
            if(indegree[neigh-'a']==0)
            q.add(neigh-'a');
        }
      }
      for(int i=0;i<26;i++)
      if(indegree[i]>0) return "";
      return result ;

      }
    }
