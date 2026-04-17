class Solution {
    public int[][] merge(int[][] intervals) {
        List<int [] > mergeList = new ArrayList<>();
        if(intervals.length<2)
        return intervals ;
        Arrays.sort(intervals,(a,b)->(a[0]-b[0])) ;
        int [] start = intervals[0] ;
        for(int i=1;i<intervals.length;i++)
        {
            if(intervals[i][0]<=start[1])
            {
                start[1] = Math.max(intervals[i][1],start[1]) ;
            }
            else
            {
                mergeList.add(start);
                start = intervals[i] ;
            }
        }
        mergeList.add(start); 
        return mergeList.toArray(new int [mergeList.size()][]) ; 
    }
}
