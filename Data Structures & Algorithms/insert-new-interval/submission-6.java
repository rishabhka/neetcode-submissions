class Solution {
    public int[][] insert(int[][] interval, int[] newInterval) {
        List<int [] > result = new ArrayList<>();
        int i=0 ; int n = interval.length ;
        
        while(i<n&&newInterval[0]>interval[i][1])
        {
        result.add(interval[i]);
        i++;
        }
        // int start = newInterval[0] ;
        // int end = newInterval[1] ; 

        while(i<n&&(newInterval[1]>=interval[i][0]))
        {
            newInterval[0] = Math.min(newInterval[0],interval[i][0]) ;
            newInterval[1] = Math.max(newInterval[1],interval[i][1]) ;
            i= i+1;
        }
        result.add(new int []{newInterval[0],newInterval[1]});
     
        while(i!=n)
        {
        result.add(interval[i]);
        i++;
        }
        return result.toArray(new int[result.size()][]) ;

        }
        
    }
