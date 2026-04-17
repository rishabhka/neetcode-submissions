class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int sum =0 , i = 1 , max = Integer.MIN_VALUE , min_speed = Integer.MAX_VALUE;
        int n = piles.length ;
        for(int k = 0;k<n;k++)
        {
            if(max<piles[k])
            max = piles[k];
        }
        int p = 1 , q =max;
        while(p<=q)
        {
            int mid = (q+p)/2;
            sum =0;
            for(int j=0;j<n;j++)
            {
            sum = sum + (int)Math.ceil((double)piles[j]/mid) ;
            }
            if(sum<=h)
            {
            if(min_speed>sum)
            min_speed = sum ;
            q = mid -1 ;
            }
            else
            p= mid +1 ;
        }
        
        return p ;
    }
}
