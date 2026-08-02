class Solution {
    int [] rank ;
    int [] parent ;
    public int findParent(int x)
    {
        if(x==parent[x]) return x;
        else return findParent(parent[x]) ;
    }
    public boolean union(int x , int y)
    {
        int parX = findParent(x) ;
        int parY = findParent(y) ;

        if(parX==parY) return true ;
        if(rank[parX]==rank[parY])
        rank[parX] ++ ;
        if(rank[parX]>rank[parY])
        parent[parY] = parX ;
        else
        parent[parX] = parY ;
        return false ;
    }
    public int minCostConnectPoints(int[][] points) {
        int n = points.length ;
        rank = new int[n] ;
        parent = new int[n] ;
        for(int i=0;i<n;i++)
        {
            rank[i] = 1;
            parent[i]  = i ;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->
        {
            return Integer.compare(a[2],b[2]) ;
        });
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                int dist = Math.abs(points[i][0]-points[j][0])+
                Math.abs((points[i][1]-points[j][1])) ;
                pq.offer(new int[]{i,j,dist});
            }
        }
        int sum = 0; int e = 0 ;
        while(!pq.isEmpty())
        {
            if(e==n) return sum ;
            int [] node = pq.poll() ;
            if(union(node[0],node[1])) continue ;
            else
            sum = sum + node[2] ;
            e ++ ;

        }
        return sum ;
    }
}
