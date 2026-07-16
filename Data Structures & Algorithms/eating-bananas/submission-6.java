class Solution {
    public int check(int [] piles,int mid,int h)
    {
        int count =0 ;
        for(int i=0;i<piles.length;i++)
        {
            count = count + (int)Math.ceil(1.0*piles[i]/mid );
        }
        return count ;
    }
    public int minEatingSpeed(int[] piles, int h) {
        if(piles.length>h) return - 1;
        int i = 1 ; int j = 0 ;
        for(int k=0;k<piles.length;k++)
        {
            j = Math.max(j , piles[k]) ;
        }
        int max = Integer.MAX_VALUE ; 
        while(i<j)
        {
            if(i>j) return -1 ;
            else
            {
                int mid = (j-i)/2+i ;
                int count = check(piles,mid,h) ;
                if(count <= h) // go left 
                j = mid ;
                else
                i = mid + 1;
            }
        }
        return j ;
    }
}
