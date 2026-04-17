class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int i =0;
        int n = intervals.length ;
        List<int []> result = new ArrayList<>();
        while(i<n&&newInterval[0]>intervals[i][1])
        {
            result.add(intervals[i]);
            i++ ;
        } int min = newInterval[0];
        int max = newInterval[1];
        while(i<n&&newInterval[1]>=intervals[i][0])
        {
            //  min = newInterval[0];
            min = Math.min(min,intervals[i][0]);

            //  max = newInterval[1];
            max = Math.max(max,intervals[i][1]);
            i++;
        }
        result.add(new int []{min,max});
        while(i<n)
        {
            result.add(intervals[i]);
            i++ ;
        }
        return result.toArray(new int[result.size()][]);

    }
}
