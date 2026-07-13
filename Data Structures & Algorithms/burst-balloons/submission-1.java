class Solution {
    public int dfs(int [] nums,int l,int r,int [][] memo)
    {
        if(l>=r) return nums[l];
        else if(memo[l][r]!=-1) return memo[l][r];
        int max = 0 ;
        for(int i=l+1;i<r;i++)
        {
            int sum = nums[l] * nums[i] * nums[r] + dfs(nums,l,i,memo)
            +dfs(nums,i,r,memo) ;
            max = Math.max(max,sum);
        }
        memo[l][r]= max ;
        return memo[l][r];
    }
    public int maxCoins(int[] nums) {
        int [] modifiedNums = new int [nums.length+2] ;
        modifiedNums[0] =1 ; modifiedNums[modifiedNums.length-1] =1 ;
        for(int i=0;i<nums.length;i++)
        {
            modifiedNums[i+1] = nums[i] ;
        }
        int [][] memo = new int [nums.length+2][nums.length+2];
        for(int i=0;i<nums.length;i++)
        Arrays.fill(memo[i],-1);
        return dfs(modifiedNums,0,modifiedNums.length-1,memo);
    }
}
