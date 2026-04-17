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
         int n = intervals.size();
         Collections.sort(intervals,(a,b)->Integer.compare(a.start,b.start));
         if(n==1)
         return true;
         int p=0;
         int q=1;
         while(q<n)
         {
            if(intervals.get(q).start<intervals.get(p).end)
            return false;
            q++;
            p++;
         }
         return true;
    }
}
