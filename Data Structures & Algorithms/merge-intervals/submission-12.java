class Solution {
    //[[1,3],[1,5],[6,7]]
    public int[][] merge(int[][] intervals) {
        
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals,(a,b)->{
            return Integer.compare(a[0],b[0]) ;
        }) ;
        int [] start = intervals[0] ;
        for(int i=1;i<intervals.length;i++)
        {
            while(i<intervals.length&&intervals[i][0]<=start[1])
            {
                start[0] = Math.min(start[0],intervals[i][0]) ;
                start[1] = Math.max(start[1],intervals[i][1]) ;
                i++;
            }
            if(i==intervals.length) break ;
            res.add(start) ;
            start = intervals[i] ;
        }
        res.add(start);
        int [][] result = new int [res.size()][2] ;
        for(int i=0;i<res.size();i++)
        result[i] = res.get(i) ;
        return result ;
    }
}
