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

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
            if(intervals.size()==0)
            return 0 ;
            Collections.sort(intervals,(a,b)->
            {
                if(a.start==b.start)
                return Integer.compare(a.end,b.end);
                return Integer.compare(a.start,b.start);
            });
            PriorityQueue<Interval> pq = new PriorityQueue<>((a,b)->
            {
                return Integer.compare(a.end,b.end);
            });
            for(int i=0;i<intervals.size();i++)
            {
                if(pq.isEmpty())
                pq.add(intervals.get(i));
                else
                {
                    if(pq.peek().end<=intervals.get(i).start)             
                    pq.poll();
                    pq.add(intervals.get(i));
                }
            }
            return pq.size();
    }
}
