class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length ;
        if(n==0) return new int [0][0];
        Arrays.sort(intervals,(a,b)->
        { 
        if(a[0]==b[0])
        return Integer.compare(a[1],b[1]);
        else 
        return Integer.compare(a[0],b[0]);
    });
        int min = intervals[0][0];
        int max = intervals[0][1];
        List<int []> result = new ArrayList<>();
        for(int i=1;i<n;i++)
        {
            if(intervals[i][0]<=max)
            {
            max = Math.max(max,intervals[i][1]) ;
            // result.add(new int[]{min,max});
            }
            else
            {
            result.add(new int[]{min,max});
            min = intervals[i][0];
            max = intervals[i][1] ;
            }
            // [[1,2],[3,5],[5,7]]
        }
        result.add(new int[]{min,max});
        return result.toArray(new int[result.size()][]);
    }
}
