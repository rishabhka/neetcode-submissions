class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length ;
        List<int [] > list = new ArrayList<>();
        if(n==1)
        return intervals ;
        else
        {
            Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
            int p=0;
            int q =1 ;
            while(q<n)
            {
                if(intervals[p][1]>=intervals[q][0])
                {
                    intervals[q][0] = Math.min(intervals[q][0],intervals[p][0]);
                    intervals[q][1] = Math.max(intervals[p][1],intervals[q][1]);
                }
                else
                {
                    int [] temp = {intervals[p][0],intervals[p][1]};
                    list.add(temp);
                }
                q++;
                p++;
            }
            int [] temp = {intervals[p][0],intervals[p][1]};
            list.add(temp);
            
        }
        return list.toArray(new int[list.size()][]);
    }
}
