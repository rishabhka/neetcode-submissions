class Solution {
    public int ways(int[] nums,int i,int sum ,int target)
    {
        if(i==nums.length&&sum==target)
        return 1;
        else if(i==nums.length) 
        return 0;

        return ways(nums,i+1,sum+nums[i],target) + ways(nums,i+1,sum-nums[i],target);


    }
    public int findTargetSumWays(int[] nums, int target) {
        if(nums.length==0)
        return 0 ;
        
        return ways(nums,0,0,target);
    }
}
