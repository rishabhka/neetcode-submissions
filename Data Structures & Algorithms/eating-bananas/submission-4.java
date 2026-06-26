class Solution {
    public boolean canComplete(int [] piles,int h ,int val)
    {
        int time =0 ;
        for(int i=0;i<piles.length;i++)
        time = time + (int)Math.ceil((double)piles[i]/val);
        if(time<=h) return true ;
        else return false ;
    }
    public int binarySearch(int [] piles,int h , int i, int j)
    {
        if(i>j) return -1;
        int mid = (i+j)/2;
        boolean mid_status = canComplete(piles,h,mid);
        boolean mid_l_status = canComplete(piles,h,mid-1);
        if(mid_status&&!mid_l_status)
        return mid ;
        else if(!mid_status)
        return binarySearch(piles,h,mid+1,j);
        else
        return binarySearch(piles,h,i,mid-1);

    }
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;

        for(int i=0;i<piles.length;i++)
        {
            max = Math.max(piles[i],max);
        }
        return binarySearch(piles,h,0,max);
    }
}
