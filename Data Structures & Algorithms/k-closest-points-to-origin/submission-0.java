class Solution {
    class Node
    {
        int x ;
        int y ;
        double dist ;
        Node(int x , int y)
        {
            this.x = x;
            this.y =y ;
            dist = Math.sqrt(x*x+y*y);
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        int [][] result = new int [k][2];
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->Double.compare(a.dist,b.dist));
        for(int i=0;i<points.length;i++)
        pq.add(new Node(points[i][0],points[i][1]));
        for(int i=0;i<k;i++)
        {
            Node temp = pq.poll();
            result[i][0] = temp.x;
            result[i][1] = temp.y;
        }
        return result;

    }
}
