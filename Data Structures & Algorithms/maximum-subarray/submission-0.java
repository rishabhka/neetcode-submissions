class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int local = nums[0];
        int global =nums[ 0] ;
        for(int i=1;i<n;i++)
        {
          if(local+nums[i]>nums[i])
          local =local + nums[i];
          else
          local = nums[i];
          if(local>global)
          global = local;
        }
        return global;
    }
}
