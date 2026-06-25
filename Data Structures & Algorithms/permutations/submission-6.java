class Solution {
    public void swap(int [] nums, int i , int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j]= temp;
        return ;
    }
    public void permute(int[] nums,int i,List<List<Integer>> result)
    {
        if(i>=nums.length)
        {
            List<Integer> perm = new ArrayList<>();
            for (int n : nums) perm.add(n);
            result.add(perm);
            return ;
        }
        else
        {
            for(int j=i;j<nums.length;j++)
            {
                swap(nums,i,j);
                permute(nums,i+1,result);
                swap(nums,i,j);
            }
        }

return ;
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permute(nums,0,result);
        return result;
    }
}
