class Solution {
    public int maxArea(int[] height) {
        int p=0;
        int q = height.length-1; int max_area =0 ;
        while(p<q)
        {
            int area = (q-p)*Math.min(height[p],height[q]);
            if(area>max_area)
            max_area=area;
            if(height[p]>height[q])
            q--;
            else
            p++;
        }
        return max_area;
    }
}