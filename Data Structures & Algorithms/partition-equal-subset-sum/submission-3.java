class Solution {
    public boolean f(int[] nums,int sum, int i, int target)
    {
        if(sum==target)
        return true ;
        else if(sum>target)
        return false ;
        if(nums.length==i)
        {
            return false;
        }
        return f(nums,sum+nums[i],i+1,target) || f(nums,sum,i+1,target) ;

    }
    public boolean canPartition(int[] nums) {
        int sum =0;
        for(int i=0;i<nums.length;i++)
        sum = sum + nums[i];
        if(sum%2!=0)
        return false;
        sum = sum /2 ;
        return f(nums,0,0,sum);
    }
}
