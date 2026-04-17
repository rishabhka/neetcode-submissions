class Solution {
    public boolean f(int [] nums,int i , int sum)
    {
        if(sum ==0)
        return true ;
        if(i>=nums.length)
        return false;
        else
        return f(nums,i+1 , sum-nums[i]) || f(nums,i+1 , sum) ;
    }
    public boolean canPartition(int[] nums) {
        int sum =0 ;
        for(int i=0;i<nums.length;i++)
        sum = sum + nums[i];
        if(sum%2!=0)
        return false ;
        sum = sum /2 ;
        
        return f(nums,0 , sum);
    }
}
