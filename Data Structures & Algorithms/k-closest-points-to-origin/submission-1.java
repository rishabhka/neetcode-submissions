class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int [][] result = new int [k][2] ;
        PriorityQueue<int []> pq = new PriorityQueue<>((a,b)->(a[2]-b[2]));

        for(int [] cord : points)
        {
            int [] newCordDist = new int [3];
            newCordDist[0] = cord[0];
            newCordDist[1] = cord[1];
            newCordDist[2] = (int )Math.pow(Math.abs(0-cord[0]),2) + (int )Math.pow(Math.abs(0-cord[1]),2) ;
            pq.add(newCordDist) ;
        }
        for(int i=0;i<k;i++)
        {
            int [] newCordDist = pq.poll();
            result[i][0] = newCordDist[0];
            result[i][1] = newCordDist[1];
        }
        

        return result ;

    }
}
