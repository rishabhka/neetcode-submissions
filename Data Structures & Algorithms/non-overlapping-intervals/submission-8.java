class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int i=0;
        int n = intervals.length ;
        
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });
        int count =0;
        while(i+1<n)
        {
            if(intervals[i+1][0]<intervals[i][1])
            {
            intervals[i+1][0] = Math.max(intervals[i+1][0],intervals[i][0]);
            intervals[i+1][1] = Math.min(intervals[i+1][1],intervals[i][1]) ;
            count ++;
            }
            i++;
        }
        return count ;
    }
}
