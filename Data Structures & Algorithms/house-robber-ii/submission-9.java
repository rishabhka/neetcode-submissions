class Solution {
        public int houseRob(int [] nums,int i,int n ,int [] dp)
    {
        if(i>=n) return 0;
        else if(dp[i]!=-1) return dp[i] ;
        else
        {
            dp[i]=  Math.max(houseRob(nums,i+1,n,dp),houseRob(nums,i+2,n,dp)+nums[i]) ;
            return dp[i] ;
        }
    }
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0] ;
        int [] dp1= new int [nums.length] ;
        int [] dp2= new int [nums.length] ;
        Arrays.fill(dp1,-1) ;
        Arrays.fill(dp2,-1) ;
        return Math.max(houseRob(nums,0,nums.length-1,dp1),houseRob(nums,1,nums.length,dp2)) ;
    }
    }
