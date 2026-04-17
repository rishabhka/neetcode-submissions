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
        // List<Interval > range = new ArrayList<>();
        if(intervals.size()<2)
        return intervals.size() ;
        Collections.sort(intervals,(a,b)->(a.start-b.start));
        // range.add(intervals.get(0));
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->(a-b)) ;
        pq.add(intervals.get(0).end) ;
        for(int i=1;i<intervals.size();i++)
        {
            if(pq.peek()>intervals.get(i).start)
            pq.add(intervals.get(i).end) ;
            else
            {
               pq.poll() ;
               pq.add(intervals.get(i).end) ;
            }
        }
        return pq.size();
    }
}
