class Solution {
	int count =0;
	public int f(int [] nums,int target,int [] dp)
	{
	if(target==0)
	{
	return 1 ;
	}
    else if(target<0)
    return 0  ;
	else if(dp[target]!=-1)
	return dp[target];
	else
	{
    int x= 0; 
	for(int i=0;i<nums.length;i++)
	x=x+f(nums,target-nums[i],dp) ;
    dp[target]=x ;
	return dp[target] ;
	}
	
	}
    public int combinationSum4(int[] nums, int target) {
	if(nums.length==0 )
	return 0;
	if(target==0)
	return 1 ;
	int [] dp = new int [target+1];
	Arrays.fill(dp,-1);
	f(nums,target,dp);
    return dp[target] ;
    }
}