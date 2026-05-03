class Solution {
    public boolean f(int [] nums,int k,int i, int [] result,int sum)
    {
        if(i==nums.length) // check if all sums eqiual
        {
            for(int j=0;j<k;j++)
            {
                if(result[j]!=result[0])
                return false;
            }
            return true;
        }
        for(int j=0;j<k;j++)
        {
            result[j] = result[j] + nums[i];
            if(result[j]>sum)   
            {
                result[j] = result[j] - nums[i];
                continue ;
            }
            if(f(nums,k,i+1,result,sum))
            return true ;
            result[j] = result[j] - nums[i];
        }
        return false;
    }
    public boolean canPartitionKSubsets(int[] nums, int k) {
        
        int [] result = new int [k];
        int sum = 0;
        for(int i=0;i<nums.length;i++)
        sum = sum + nums[i];
        if(sum%k!=0)
        return false ;
        Arrays.sort(nums);
        for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        return f(nums,k,0,result,sum/k);
    }
}