class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // [[1,2],[2,4],[1,4]]
        Arrays.sort(intervals,(a,b)->
        {
            return Integer.compare(a[0],b[0]) ;
        });
        int [] start = intervals[0] ; int count =0;
        for(int i=1;i<intervals.length;i++)
        {
            if(intervals[i][0]<start[1])
            {
                if(intervals[i][1]<start[1])
                {
                    start[0] = intervals[i][0] ;
                    start[1] = intervals[i][1] ;
                }
                count ++;
            }
            else start = intervals [i] ;

        }
        return count ;
    }
}
