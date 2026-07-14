class Solution {
    public int getIdx(List<List<Integer>> adjList,int [] indegree,Queue<Integer >q,int [] idx)
    {
        int k=0;
        while(!q.isEmpty())
        {
            int node = q.poll();
            idx[k] = node ; k ++ ;
            for(int neigh : adjList.get(node))
            {
                indegree[neigh] -- ;
                if(indegree[neigh]==0)
                q.add(neigh);
            }
        }
        for(int i=0;i<indegree.length;i++)
        if(indegree[i]>0) return -1 ;
      return 0;
    }
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        int [][] res = new int [k][k] ;
        int [] indegree1 = new int[k] ;
        int [] indegree2 = new int[k] ;
        List<List<Integer>> adjList1 = new ArrayList<>();
        List<List<Integer>> adjList2 = new ArrayList<>();
        for(int i=0;i<k;i++)
        {
            adjList1.add(new ArrayList<>());
            adjList2.add(new ArrayList<>());
        }
        for(int i=0;i<rowConditions.length;i++)
        {
            indegree1[rowConditions[i][1]-1] ++ ;
            adjList1.get(rowConditions[i][0]-1).add(rowConditions[i][1]-1);
        }
        for(int i=0;i<colConditions.length;i++)
        {
            indegree2[colConditions[i][1]-1] ++ ;
            adjList2.get(colConditions[i][0]-1).add(colConditions[i][1]-1);
        }
        int [] idx1 = new int [k] ;
        int [] idx2 = new int [k] ;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        for(int i=0;i<k;i++)
        {
            if(indegree1[i]==0) q1.offer(i);
            if(indegree2[i]==0) q2.offer(i);
        }
        if(getIdx(adjList1,indegree1,q1,idx1)==-1) return new int[0][0] ;
        if(getIdx(adjList2,indegree2,q2,idx2)==-1) return new int[0][0] ;
        for(int i=0;i<k;i++)
        {
            for(int j=0;j<k;j++)
            {
                if(idx1[i]==idx2[j])
                res[i][j] = idx1[i]+1;
            }
        }
        return res ;
    }
}