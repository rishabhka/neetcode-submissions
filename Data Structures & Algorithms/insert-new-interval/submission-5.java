class Solution {
    public int[][] insert(int[][] interval, int[] newInterval) {
        List<int [] > result = new ArrayList<>();
        int i=0 ; int n = interval.length ;
        
        while(i<n&&newInterval[0]>interval[i][1])
        {
        result.add(interval[i]);
        i++;
        }
        // if(i==n) // Add if newInterval is last elem
        // result.add(newInterval) ;
        // else
        // {
        // If two nodes merge 
        int start = newInterval[0] ;
        int end = newInterval[1] ; 

        while(i<n&&(newInterval[1]>=interval[i][0]))
        {
            start = Math.min(start,interval[i][0]) ;
            end = Math.max(end,interval[i][1]) ;
            i= i+1;
        }
        result.add(new int []{start,end});
     
        while(i!=n)
        {
        result.add(interval[i]);
        i++;
        // }
        }
        return result.toArray(new int[result.size()][]) ;

        }
        
    }
