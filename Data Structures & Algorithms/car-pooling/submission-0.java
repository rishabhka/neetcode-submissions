class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int max = 0;
        int [] nums  = new int [1001] ;
        for(int i=0;i<trips.length;i++)
        {
                nums[trips[i][1]] += trips[i][0] ;
                nums[trips[i][2]] -= trips[i][0] ;
    }
    for(int i=0;i<1001;i++)
    {
        max = max + nums[i] ;
        if(max>capacity )
        return false ;
    }
    
    return true ;
}
}