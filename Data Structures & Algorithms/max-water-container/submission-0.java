class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;
        int p =0;
        int q = n-1;
        int max_area =0 ;
        while(p<=q)
        {
            if(max_area<Math.min(heights[p],heights[q]) * (q-p))
            max_area = Math.min(heights[p],heights[q])* (q-p);
            if(heights[p]<heights[q])
            p++;
            else
            q--;
        }
        return max_area;
    }
}
