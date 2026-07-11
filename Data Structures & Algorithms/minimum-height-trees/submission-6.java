class Solution {
    public int dfs(List<List<Integer>>  adjList,int node,int [] heights
    ,int [] visited)
    {
        // if(visited==null) return ;
        visited[node]= 1; 
        int max_dist=0; 
        for(int i=0;i<adjList.get(node).size();i++)
        {
            int neigh = adjList.get(node).get(i) ;
            if(visited[neigh]==1)
            continue ;
            max_dist = Math.max(max_dist,dfs(adjList,neigh,heights,
            visited)+1);
        }
        // if(heights[node]<max_dist)
        // heights[node] = max_dist ;
        return max_dist ;
    }
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        int [] heights = new int [n] ;
        // Arrays.fill(heights,0);
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<n;i++)
        adjList.add(new ArrayList<>());
        
        for(int i=0;i<edges.length;i++)
        {
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }
        for(int i=0;i<n;i++)
        {
        int [] visited = new int [n] ;
        heights[i] = dfs(adjList,i,heights,visited); // will contai max heiht
        }
        int min =Integer.MAX_VALUE;
        for(int i=0;i<n;i++)
        {
        min = Math.min(min,heights[i]);
        System.out.print(heights[i]+" ");
        }

        List<Integer> result = new ArrayList<>();
        for(int i=0;i<n;i++)
        if(heights[i]==min)
        result.add(i);

        return result;

    }
}