class Solution {
    public boolean dfs(int [] nums,int k,int sum,int i,boolean [] visited,int total_sum)
    {
        if(k==0) return true ;
        if(sum==0) {
            return dfs(nums,k-1,total_sum,0,visited,total_sum) ;
        }
        else
        {
            for(int j=i;j<nums.length;j++)
            {
                if(sum-nums[j]<0||visited[j]==true) continue ;
                visited[j] = true;
                if(dfs(nums,k,sum-nums[j],j+1,visited,total_sum)) return true ;
                visited[j] = false;
            }
            return false;
        }

    }
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum =0 ;
        for(int i=0;i<nums.length;i++) sum = sum + nums[i] ;
        if(sum%k!=0) return false ;  sum = sum / k;
        boolean [] visited = new boolean [nums.length] ;
        if(dfs(nums,k,sum,0,visited,sum) ) return true ;   
        return false ;
    }
}