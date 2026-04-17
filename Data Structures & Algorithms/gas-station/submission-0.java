class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length ;
        for(int i=0;i<n;i++)
        {
            // int gas = 0 ;
            int travel_cost = 0;
            int j=i ;
            int count =0 ;
            for(;j<n;j++)
            {
                travel_cost = travel_cost + gas[j] - cost[j];
                System.out.println(j+" "+travel_cost);
                if(travel_cost<0)
                break ;
                count ++ ;
            }
            for(j=0;j<i;j++)
            {
                travel_cost = travel_cost + gas[j] - cost[j];
                System.out.println(j+" "+travel_cost);
                if(travel_cost<0)
                break ;
                count ++ ;
            }
            if(count==n)
            return i ;
        }
        return -1;
    }
}
