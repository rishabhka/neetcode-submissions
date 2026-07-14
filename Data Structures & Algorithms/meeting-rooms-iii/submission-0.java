class Solution {
    public int mostBooked(int n, int[][] meetings) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) ->
            {
                return Integer.compare(a[0],b[0]);
            }
        );
        int [] count = new int [n] ;
        int [][] occupancy = new int [n][2] ;
        for(int i=0;i<meetings.length;i++)
        {
            pq.add(meetings[i]);
        }
        while(!pq.isEmpty())
        {
            int [] node = pq.poll(); boolean isInsert = false ;
            for(int i=0;i<n;i++)
            {
                if(occupancy[i][1]<=node[0]) // insert it
                {
                    occupancy[i] = node ;
                    isInsert = true ;
                    count[i] ++ ;
                    break ;
                }
            }
            if(!isInsert) // if no insert then insert to min idx , which is freed earliest
            {
                int i =0 ; // to store room which is closest
                int max = Integer.MAX_VALUE ;
                for(int k=0;k<n;k++) // to find min last value
                {
                    if(occupancy[k][1]<max)
                    {
                        max = occupancy[k][1];
                        i = k;
                    }
                }
                int diff = node[1]-node[0] ;
                node[0] = occupancy[i][1] ;
                node[1] = occupancy[i][1] + diff ;
                occupancy[i] = node;
                count[i] ++ ;
            }

        } int idx = -1; int max =0;
        for(int i=0;i<n;i++)
        {
        if(count[i]>max)
        {
        max = count[i] ;
        idx = i;
        }
        }
        return idx;
    }
}