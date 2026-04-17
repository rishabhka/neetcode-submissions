class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length ;
        if(n==1)
        return 0;
        else
        {
            int p = 0 ;
            int q = 1 ;
            Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
            int counter = 0;
            while(q<n)
            {
                System.out.println(intervals[p][0]+" "+intervals[p][1]+" "+intervals[q][0]+" "+intervals[q][1]);
                if(intervals[p][1]>intervals[q][0])
                {
                    if(intervals[p][1]<=intervals[q][1])
                    {
                     intervals[q][1] = intervals[p][1] ;
                     intervals[q][0] = intervals[p][0] ;
                     
                    }
                    counter ++ ;
                }
                p++;
                q++;
            }
            return counter ;
        }
        
    }
}
