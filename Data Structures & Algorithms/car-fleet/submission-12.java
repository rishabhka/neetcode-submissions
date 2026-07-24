class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        // PriorityQueue<int [] > pq = new PriorityQueue<>((a,b)->
        // {
        //     return Integer.compare(a[1],b[1])
        // }) ;
        int n = position.length ;
        double [][] time = new double [n][2] ;
        for(int i=0;i<n;i++)
        {
            double t =  ((target-position[i]) / (double)speed[i]) ;
            time[i] = new double[] {position[i], t};
        }
        Arrays.sort(time,(a,b)->
        {
            return Double.compare(b[0],a[0]) ;
        }); 
        int fleet = 0;
        for(int i=0;i<n;i++)
        System.out.println(time[i][0]+" " +time[i][1]) ;
        for(int i=0;i<n;)
        {
            double [] el = time[i] ;
            fleet ++ ; int j = i +1 ;
            while(j<n)
            {
                if(time[j][1]>el[1])
                break;
                j++;
            }
            i = j;
        }
        return fleet ;
    }
}
