class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int idx = -1;
        for(int i=0;i<gas.length;i++)
        {
            int curr_cost =0; int k=gas.length;
            int j = i;
            while(k!=0)
            {
                curr_cost = curr_cost + gas[j]- cost[j] ;
                if(curr_cost<0)
                break ;
                k--;
                j++;
                j = j%n;
            }
            if(k==0)
            idx = i;
        }
        return idx;
    }
}
