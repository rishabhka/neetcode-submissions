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
        List<Interval > range = new ArrayList<>();
        if(intervals.size()<2)
        return intervals.size() ;
        Collections.sort(intervals,(a,b)->(a.start-b.start));
        range.add(intervals.get(0));
        for(int i=1;i<intervals.size();i++)
        {
            Interval el = intervals.get(i) ;
            boolean shouldAdd = true;  
            for(int j=0;j<range.size();j++)
            {
                if(range.get(j).end<=el.start)
                {
                Interval newNode = new Interval(range.get(j).start,el.end);
                range.set(j,newNode);
                shouldAdd = false ;
                break ;
                }
            }
            if(shouldAdd)
            {
            range.add(el); 
            }
        }
        return range.size();
    }
}
