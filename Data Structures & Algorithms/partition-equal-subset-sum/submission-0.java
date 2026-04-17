class Solution {
    public boolean checkSubsum(int [] nums,int i ,int sub1,int sub2)
    {
        if(nums.length==i)
        {
            if(sub1==sub2)
            return true;
            else return false;
        }
        else
        {
            return checkSubsum(nums,i+1,sub1+nums[i],sub2) || checkSubsum(nums,i+1,sub1,sub2+nums[i]) ;
        }

    }
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum =0;
        for(int i=0;i<n;i++)
        sum = sum + nums[i];
        if(sum%2!=0)
        return false;
        else
        {
           return checkSubsum(nums,0,0,0);
        }
    }
}
