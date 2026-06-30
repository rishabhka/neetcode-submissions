class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals,(a,b)->
        {
            if(a[0]==b[0]) return Integer.compare(a[1],b[1]);
            else return Integer.compare(a[0],b[0]);
        });
        // HashMap<Integer,Integer> map = new HashMap<>();
        int [][] sortedq = new int [queries.length][2];
        for(int i=0;i<queries.length;i++)
        {
            sortedq[i][0] = queries[i];
            sortedq[i][1] = i;
        }

        Arrays.sort(sortedq,(a,b)->
        {
            return Integer.compare(a[0],b[0]);
        });
        // (dist,lastnode)
        PriorityQueue<int [] > pq = new PriorityQueue<>((a,b)->
        {
            if(a[0]==b[0]) return Integer.compare(a[1],b[1]);
            else return Integer.compare(a[0],b[0]);
        });
        int [] result = new int[queries.length]; 
        int j=0; // for result
        int i=0; // For quries 
        for(int [] q:sortedq)
        {
            while(i<intervals.length&&q[0]>=intervals[i][0])
            {
            pq.offer(new int []{intervals[i][1]-intervals[i][0]+1,intervals[i][1]});
            i++;
            }
            while(!pq.isEmpty()&&pq.peek()[1]<q[0])
            pq.poll();
            if(pq.isEmpty()) 
            {
                result[j] = -1;
                j++;
                continue ;
            }
            result[j] = pq.peek()[0];
            j++;
        }
        int [] mapper = new int[queries.length];
        for(int k=0;k<queries.length;k++)
        {
            mapper[sortedq[k][1]] = result[k];
        }
        return mapper;

    }
}