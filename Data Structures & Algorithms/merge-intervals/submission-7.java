class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->(a[0]-b[0]));
        int i=0;
        List<int [] > result = new ArrayList<>();
        int n = intervals.length ;
        while(i+1<n)
        {
            if(intervals[i+1][0]<=intervals[i][1]) //merge them
            {
                intervals[i+1][0]=intervals[i][0] ;
                intervals[i+1][1] = Math.max(intervals[i][1], intervals[i+1][1]);
            }
            else
            result.add(intervals[i]) ;

            i++;

        }
        result.add(intervals[i]) ;
        // result.add
        return result.toArray(new int[result.size()][]);
    }
}
