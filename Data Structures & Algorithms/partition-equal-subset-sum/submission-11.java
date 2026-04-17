class Solution {
    public boolean f(int[] nums, int i, int sum, int curr, Boolean[][] dp) {
        if (curr == sum)           // ✅ check success FIRST
            return true;
        if (i >= nums.length || curr > sum)
            return false;
        if (dp[i][curr] != null)
            return dp[i][curr];

        dp[i][curr] = f(nums, i+1, sum, curr + nums[i], dp) 
                   || f(nums, i+1, sum, curr, dp);
        return dp[i][curr];
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % 2 != 0) return false;

        sum = sum / 2;
        Boolean[][] dp = new Boolean[nums.length][sum + 1]; // ✅ sized correctly now
        return f(nums, 0, sum, 0, dp);
    }
}