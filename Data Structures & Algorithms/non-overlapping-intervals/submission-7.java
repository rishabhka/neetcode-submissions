class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length<2)
        return 0 ;
        int count = 0 ;
        Arrays.sort(intervals,(a,b)->(a[0]-b[0]));
        int [] start = intervals[0] ;
        for(int i =1;i<intervals.length;i++)
        {
            System.out.println(start[0]+" "+start[1]);
            if(intervals[i][0]<start[1]) //overlap
            {
                System.out.println("ss");
            if(intervals[i][1]<start[1])
            {
            start = intervals [i] ;
            count ++ ;
            }
            else count ++ ;
            }
            else
            {        
            start = intervals[i];
            }
        }
        // count ++ ;
        return count ;
    }
}
