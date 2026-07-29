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
        if(intervals.size()<2) return intervals.size() ;
        Collections.sort(intervals,(a,b)->
        {
            return Integer.compare(a.start,b.start) ;
        }) ;
        PriorityQueue<Interval> pq = new PriorityQueue<>((a,b)->
        {
            return Integer.compare(a.end,b.end) ;
        });
        pq.offer(intervals.get(0))  ;
        for(int i=1;i<intervals.size();i++)
        {
            if(intervals.get(i).start<pq.peek().end)
            pq.offer(intervals.get(i)) ;
            else
            {
            pq.poll();
            pq.offer(intervals.get(i)) ;
            }

        }
        return pq.size();
    }
}
