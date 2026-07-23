class Solution {
    public int maxArea(int[] heights) {
        int p =0; int q = heights.length-1; int max = Integer.MIN_VALUE ;
        while(p<q)
        {
            max = Math.max(max,Math.min(heights[p],heights[q]) * (q-p) );
            if(heights[p]<=heights[q])
            p++ ;
            else 
            q--;
        }
        return max ; 
    }
}
