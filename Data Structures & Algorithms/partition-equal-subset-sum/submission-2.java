class Solution {
    public boolean f(int[] nums,int sum1 ,int sum2,int i)
    {
        if(nums.length==i)
        {
            if(sum1==sum2)
            return true;
            else return false;
        }
        return f(nums,sum1+nums[i],sum2,i+1) || f(nums,sum1,sum2+nums[i],i+1) ;

    }
    public boolean canPartition(int[] nums) {
        return f(nums,0,0,0);
    }
}
