class Solution {
    public class Node
    {
        int i ;
        int j ;
        int count ;
        Node(int i,int j,int count)
        {
            this.i = i;
            this.j =j;
            this.count = count ;
        }
    }
    public void visit(int[][] matrix, int m , int n,int [][] visited,Queue<Node> q,int start , int end)
    {
        while(!q.isEmpty())
        {
            Node top = q.poll();
            int i = top.i, j = top.j , count = top.count;
            if(i<0||j<0||i>m-1||j>n-1)
            continue ;
            else if (visited[i][j]==-1)
            continue ;
            else if(matrix[i][j]==-1)
            continue ;
            else if(matrix[i][j]!=0||count==0)
            {
            // count = Math.abs(start-i) + Math.abs(end -j);
            if(matrix[i][j]>count)
            matrix[i][j]=count;
            visited[i][j]=-1;
            q.add(new Node(i+1,j,count+1));
            q.add(new Node(i-1,j,count+1));
            q.add(new Node(i,j+1,count+1));
            q.add(new Node(i,j-1,count+1));
            }
            
        }

    }
    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                Queue<Node > q = new LinkedList<>();
                int [][] visited = new int [m][n] ;
                if(grid[i][j]==0)
                {
                visited[i][j]=1;
                q.add(new Node(i,j,0));
                visit(grid,m,n,visited,q,i,j);
                }

            }
        }
        return;
    }
}
