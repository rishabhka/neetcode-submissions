class Solution {
    public void cs(int[] nums,int target,List<List<Integer>> result,List<Integer> temp,int i,int sum)
    {
        
        if(sum==target&&i==nums.length)
        {
            result.add(new ArrayList<>(temp));
            return ;
        }
        if(sum>target||i>=nums.length)
        return ;
        cs(nums,target,result,temp,i+1,sum);  //skip
        temp.add(nums[i]);
        cs(nums,target,result,temp,i,sum+nums[i]);  //take
        temp.remove(temp.size()-1);
        return ;
    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        cs(nums,target,result,temp,0,0);
        return result ;
    }
}
