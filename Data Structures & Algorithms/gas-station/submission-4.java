class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length ; int total = 0;  int idx =0;
        int sum =0;
        for(int i=0 ;i<n;i++)
        {
            sum = sum + gas[i] - cost[i] ;
            gas[i] = gas[i] - cost[i] ;
        }
        if(sum<0)
        return -1 ;
        else 
        {
            for(int i=0 ;i<n;i++)
        {
            total = total + gas[i] ;
            if(total<0)
            {
            total = 0 ;
            idx = i + 1 ;
            }
        }
        return idx ;
        }

        
    }
}
