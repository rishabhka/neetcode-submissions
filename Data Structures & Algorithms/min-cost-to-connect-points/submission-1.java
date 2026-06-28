class Solution {
    class UnionFind
        {
            int [] parent ;
            int [] rank ;
            UnionFind(int n)
            {
                parent = new int[n];
                rank = new int[n];
                for(int i=0;i<n;i++)
                {
                    parent[i]= i;
                    rank[i] = 1;
                }
            }
            public int findParent(int x)
            {
                int y = parent[x];
                if(x!=y)
                return findParent(y) ;
                else return y ;
            }
            public boolean union(int u, int v)
            {
                int x = findParent(u) ;
                int y = findParent(v) ;

                if(x==y) return true ; // cycle

                if(rank[x]>rank[y])
                {
                    parent[y] = x;
                    rank[x] = rank[x] +1 ;
                }
                else
                {
                   parent[x] = y;
                   rank[y] = rank[y] +1 ; 
                }
                return false;
            }
        }
    public int minCostConnectPoints(int[][] points) {
       List<int[]> edges = new ArrayList<>();
        for(int i=0;i<points.length;i++)
        {
            for(int j=i+1;j<points.length;j++)
            {
                int dist = Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);
                edges.add(new int[]{i,j,dist});
            }
        }
        Collections.sort(edges,(a,b)->Integer.compare(a[2],b[2]));
        UnionFind uf = new UnionFind(points.length); 
        int cost =0; int node =0;
        for(int i=0;i<edges.size();i++)
        {
            if(!uf.union(edges.get(i)[0],edges.get(i)[1])) // its cycle // skip it
            {
            cost = cost + edges.get(i)[2] ;
            node ++;
            }
        }
        return cost ;

    }
}
