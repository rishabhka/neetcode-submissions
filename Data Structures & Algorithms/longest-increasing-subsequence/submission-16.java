class Solution {
    public int lengthOfLIS(int[] nums) {
        int [] dp = new int[nums.length] ;
        Arrays.fill(dp,1) ; int max =0 ;
        for(int i=0;i<nums.length;i++)
        {
            int j = i ;
            while(j>=0)
            {
            if(nums[j]<nums[i]&&dp[j]+1>dp[i])
            dp[i]= dp[j] +1 ;
            j-- ;
            max = Math.max(max,dp[i]) ;
            }
        } 

        return max ;

    }
}
