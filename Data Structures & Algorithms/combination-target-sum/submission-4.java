class Solution {
    public void comb(int [] nums,int i,int target,List<Integer>  temp,int sum,List<List<Integer>> result)
    {
        if(target==sum)
        {
            result.add(new ArrayList<>(temp));
        }
        else if(target<sum)
        return ;
        for(int j=i;j<nums.length;j++)
        {
            temp.add(nums[j]);
            comb(nums,j,target,temp,sum+nums[j],result);
            temp.remove(temp.size()-1);

        }
    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        comb(nums,0,target,temp,0,result);
        return result;
    }
}
