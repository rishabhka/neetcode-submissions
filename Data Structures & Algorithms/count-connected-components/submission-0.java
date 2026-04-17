class Solution {
    public int countComponents(int n, int[][] edges) {
         
         int m = edges.length;
         List<List<Integer>> adjList = new ArrayList<>();

         for(int i=0;i<n;i++)
         adjList.add(new ArrayList<>());

         for(int i=0;i<m;i++)
         {
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
         }
         boolean [] visited = new boolean [n];
         int count =0;

         for(int i=0;i<n;i++)
         {
            if(!visited[i])
            {
                HashSet<Integer> set = new HashSet<>();
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                set.add(i);
                
                while(!q.isEmpty())
                {
                    int ele = q.poll();
                    visited[ele] = true;
                    for(int j=0;j<adjList.get(ele).size();j++)
                    {
                        if(!set.contains(adjList.get(ele).get(j)))
                        {
                            set.add(adjList.get(ele).get(j));
                            q.add(adjList.get(ele).get(j));
                            // count++;
                            
                        }
                    }
                }
                count ++;
                
            }
         }
         return count ;
    }
}
