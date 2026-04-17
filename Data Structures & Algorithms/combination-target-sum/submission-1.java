class Solution {
    public void f(int[] nums,int target,int i,List<List<Integer>> result,List<Integer> temp,int sum)
    {
        if(sum==target)
        {
            result.add(new ArrayList<>(temp));
        }
        else if(sum>target||i>=nums.length)
        return ;
        else
        {
            temp.add(nums[i]);
            f(nums,target,i,result,temp,sum+nums[i]);   
            temp.remove(temp.size()-1);
            f(nums,target,i+1,result,temp,sum);  
        }

    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        f(nums,target,0,result,temp,0);
        return result ;
    }
}
