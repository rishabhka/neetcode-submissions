class Solution {
    public boolean canPartition(int[] nums) {
    int sum = 0;
    for (int n : nums) sum += n;
    if (sum % 2 != 0) return false;       // odd total: impossible
    int target = sum / 2;

    boolean[] dp = new boolean[target + 1];
    dp[0] = true;     
    for(int num:nums)
    {
        for(int j=target;j>=num;j--)
        {
            if(dp[j-num])
            dp[j] = dp[j] || dp[j-num];
        }
    } 
    return dp[target];
    }
}
