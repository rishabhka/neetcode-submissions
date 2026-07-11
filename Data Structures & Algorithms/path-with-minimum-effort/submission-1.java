class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        
        PriorityQueue<int []> pq = new PriorityQueue<>(
            (a,b) -> 
            {
                return Integer.compare(a[2],b[2]);
            }
        );
        pq.offer(new int[]{0,0,0,heights[0][0]}); // x,y , curr dist , curr height
        int [] visited = new int[n*m] ;
        int [] distance = new int[n*m] ;
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[0] = 0;
        int [][] dirs = new int [][] {{-1,0},{1,0},{0,1},{0,-1}};
        while(!pq.isEmpty())
        {
            int [] node = pq.poll();
            int pos = node[0]*m + node[1] ;
            if(node[0]==n-1&&node[1]==m-1) return distance[pos];
            if(visited[pos]==1) continue ;
            visited[pos] = 1;
            for(int [] dir :dirs)
            {
                int x = node[0]+ dir[0] ;
                int y = node[1] + dir[1];
                if(x<0||y<0||x>=n||y>=m)
                continue ;
                else if(visited[x*m+y]==1) 
                continue ;
                int newDist = Math.abs(node[3] - heights[x][y]) ;
                newDist = Math.max(newDist,node[2]);
                if(newDist<distance[x*m+y])
                {
                distance[x*m+y]=newDist;
                pq.offer(new int []{x,y,newDist,heights[x][y]});
                }
            }

        }
        return -1;
    }
}