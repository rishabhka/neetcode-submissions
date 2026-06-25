class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int [][] result = new int [k][2];
        PriorityQueue<double[]> pq = new PriorityQueue<>(
            (a,b)->Double.compare(a[2],b[2]));
        for(int i=0;i<points.length;i++)
        {
            double dist = Math.sqrt(points[i][0]*points[i][0] + points[i][1]*points[i][1]);
            pq.add(new double []{points[i][0],points[i][1],dist});
        }
        int i=0;
        while(i!=k)
        {
            double [] node = pq.poll();
            result[i][0]=(int)node[0];
            result[i][1]=(int)node[1];
            i++;
        }


        return result;

    }
}
