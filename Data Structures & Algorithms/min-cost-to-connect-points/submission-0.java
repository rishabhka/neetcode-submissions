class Solution {
    public class DSU
    {
        int [] parent ;
        int [] rank ;

        DSU(int vertex)
        {
            this.parent = new int [vertex] ;
            this.rank = new int [vertex] ;
            for(int i=0;i<vertex;i++)
            {
            parent[i] = i ;
            rank[i] = 0 ;
            }
        }

        int find(int x)
        {
            if(x==parent[x])
            return x ;
            else return find(parent[x]);

        }
        boolean union(int x, int y)
        {
            int parX = find(x);
            int parY = find(y) ;

            if(parX==parY)
            return true ;

            else if(rank[parX]>rank[parY])
            parent[parY] = parent[parX] ;

            else if(rank[parY]>rank[parX])
            parent[parX] = parent[parY] ;

            else
            {
                rank[parY] ++ ;
                parent[parX] = parent[parY] ;
            }
    return false;
        }

    }
    public int minCostConnectPoints(int[][] points) {

        int vertex = points.length ;
        List<List<int [] > > adjList = new ArrayList<>();

        for(int i=0;i<vertex;i++)
        adjList.add(new LinkedList<>());

        PriorityQueue<List<Integer>> pq = new PriorityQueue<>((a,b)->(a.get(0)-b.get(0)));

        // for(int i=0;i<vertex;i++)
        // adjList.get(i).put()

        for(int i=0;i<vertex;i++)
        {
            for(int j=i+1;j<vertex;j++)
        {
            int dist = Math.abs(points[i][0]-points[j][0]) + Math.abs(points[i][1]-points[j][1]) ;
            pq.add(Arrays.asList(dist,i,j));
        }
        }
        int total_distance =0;
        // int [] parent ;
        // int [] rank ;
        // for(int i=0;i<vertex;i++)
        // {
        //     parent[i] = i ;
        //     rank[i] = 0 ;
        // }
        DSU dsu = new DSU(vertex) ;
        while(!pq.isEmpty())
        {
            List<Integer > node = pq.poll();
            
            if(dsu.union(node.get(1),node.get(2)))
            continue ; // cycle detected 
            else 
            {total_distance = total_distance + node.get(0);
             System.out.println(node.get(0) + " "+node.get(1)+" "+node.get(2));
            }
        }
        for(int i=0;i<vertex;i++)
        System.out.print(dsu.parent[i] + " ");
        

        return total_distance ;
        
    }
}
