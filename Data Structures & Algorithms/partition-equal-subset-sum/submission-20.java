class Solution {
    public boolean partition(int [] nums,int i,int target,Boolean [][] memo) 
    {
        if(target == 0) return true ;
        else if(target <0 || i==nums.length) return false;
        else if(memo[i][target]!=null) return memo[i][target] ;
        else
        {
            memo[i][target]= partition(nums,i+1,target-nums[i],memo) || partition(nums,i+1,target,memo) ;
            return memo[i][target] ;
        }

    }
    public boolean canPartition(int[] nums) {
        int sum = 0; 
        for(int num :nums) sum = sum + num ;
        if(sum%2!=0) return false;
        sum = sum /2 ;
        Boolean [][] memo = new Boolean [nums.length][sum+1] ;
        return partition(nums,0,sum,memo) ;
    }
}
