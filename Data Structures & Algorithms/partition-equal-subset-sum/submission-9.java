class Solution {
    public boolean f(int [] nums ,int i , int sum,int curr)
    {
        if(i>=nums.length)
        return false ;
        else if(sum == curr)
        return true ;
        else return f(nums,i+1,sum,curr+nums[i]) || f(nums,i+1,sum,curr) ;
    }
    public boolean canPartition(int[] nums) {
        // if(nums.length%2!=0)
        // return false;
        int sum =0 ;
        for(int num:nums)
        sum = sum + num ;
        if(sum%2!=0)
        return false;
        sum = sum /2 ;
        return f(nums,0,sum , 0 );
    }
}
