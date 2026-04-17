class Solution {

    public void f(int[] nums,int i,int sum,int target,HashSet<List<Integer>> result,List<Integer> temp)
    {
        if(sum==target)
        {
            result.add(new ArrayList<>(temp));
        }
        else if(sum>target || i>=nums.length)
        return ;
        else
        {
            temp.add(nums[i]);
            f(nums,i+1,sum+nums[i],target,result,temp);
            temp.remove(temp.size()-1);
            f(nums,i+1,sum,target,result,temp);
        }

    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        HashSet<List<Integer>> result = new HashSet<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(candidates);
        f(candidates,0,0,target,result,temp);
        return new ArrayList<>(result) ;
    }
}
