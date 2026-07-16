class Solution {
    public int allBoxOccupied(int [] weights,int mid,int days)
    {
        int count =0; int curr =0; int max = Integer.MIN_VALUE ;
        for(int i=0;i<weights.length;i++)
        {
            curr = curr +  weights[i] ;
            if(curr>mid)
            {
                curr = weights[i];
                count = count + 1 ;
            }
            max = Math.max(curr,max);
        }
        
         return count + 1 ;
    }
    public int shipWithinDays(int[] weights, int days) {
        int sum = 0 ; int max = Integer.MIN_VALUE ;
        for(int i=0;i<weights.length;i++)
        {
            max = Math.max(max,weights[i]);
            sum = sum + weights[i] ;
        } int i = max ; int j = sum ;
        while(i<j)
        {
            if(i>=j) return i ;
            else
            {
            int mid = (j-i)/2 + i ;
            int tot_days = allBoxOccupied(weights,mid,days) ;
            if(tot_days<=days)
            j = mid ;
            else
            i = mid +1 ;
            }

        }
        return i;
    }
}