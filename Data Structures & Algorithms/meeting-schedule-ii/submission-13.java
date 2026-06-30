/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */
// [(0,40),(5,10),(6,20)]. ->3
// [(0,40),(5,10),(15,20)] -> 2
// [(0,3),(5,10),(15,20)] -> 2
class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        Collections.sort(intervals,(a,b)->
        {
            if(a.start==b.start) return Integer.compare(a.end,b.end);
            else return Integer.compare(a.start,b.start);
        });
        int n = intervals.size();
        if(n==0)
        return 0;
        PriorityQueue<Interval> pq = new PriorityQueue<>(
            (a,b)->
            {
            return Integer.compare(a.end,b.end);
            }
        );
        pq.add(intervals.get(0));

        for(int i=1;i<n;i++)
        {
            if(pq.peek().end<=intervals.get(i).start)
            {
                pq.poll();
                pq.offer(intervals.get(i));
            }
            else
            {
                pq.offer(intervals.get(i));
            }
        }
        return pq.size();
        
    }
}
