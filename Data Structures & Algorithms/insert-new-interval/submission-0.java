class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<List<Integer>> list = new ArrayList<>();
 
        int n = intervals.length ;
        int k=0;
        while(k<n&&intervals[k][1]<newInterval[0])
        {
           list.add(Arrays.asList(intervals[k][0],intervals[k][1]));
           
           k++; 
        }
        int start = newInterval[0];
        int stop = newInterval[1] ;
        while(k<n&&intervals[k][0]<=newInterval[1])
        {
            start = Math.min(intervals[k][0],start) ;
            stop = Math.max(intervals[k][1],stop) ;
            k++;
        }
        list.add(Arrays.asList(start,stop));
        while(k<n)
        {
            list.add(Arrays.asList(intervals[k][0],intervals[k][1]));
            k++;
        }
        int [][] result = new int [list.size()][2];

        for(int i=0;i<list.size();i++)
        {
            result[i][0] = list.get(i).get(0);
            result[i][1] = list.get(i).get(1);

        }
        return result ;
        
    }
}
