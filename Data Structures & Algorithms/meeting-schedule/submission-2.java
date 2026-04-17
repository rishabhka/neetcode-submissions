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
    public boolean canAttendMeetings(List<Interval> intervals) {
        int i=0;
        Collections.sort(intervals,(a,b)->
        {
            if(a.start!=b.start)
            return Integer.compare(a.end,b.end);
            return Integer.compare(a.start,b.start);
        });
        while(i+1<intervals.size())
        {
            if(intervals.get(i).end>intervals.get(i+1).start)
            return false;
            i++;

        }
        return true ;
    }
}
