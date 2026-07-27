class Solution {
    public boolean dfs(int [] nums,int k,int sum,int i,int [] par)
    {
        if(nums.length==i) return true ;
        else
        {
            for(int j=0;j<k;j++)
            {
                if(par[j]+nums[i]>sum||nums[i]>sum) continue ;
                par[j] = par[j] + nums[i] ;
                if(dfs(nums,k,sum,i+1,par)) return true ;
                par[j] = par[j] - nums[i] ;
            }
            return false;
        }

    }
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum =0 ;
        for(int i=0;i<nums.length;i++) sum = sum + nums[i] ;
        if(sum%k!=0) return false ;
        sum = sum / k;
        int [] par = new int [k] ;
        Arrays.sort(nums) ;
        for(int i=0;i<nums.length/2;i++)
        {
        int temp =  nums[i] ;   
        nums[i] = nums[nums.length-i-1] ;
        nums[nums.length-i-1]= temp;
        }
        return dfs(nums,k,sum,0,par) ;
    }
}