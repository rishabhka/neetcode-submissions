class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public void f(int [] nums,int target,int i,int sum,List<Integer> temp)
    {
        if(sum==target)
        {
            result.add(new ArrayList<>(temp));
            return ;
        }
        else if(i==nums.length||sum>target)
        return ;
        else
        {
            f(nums,target,i+1,sum,temp);  // Skip it 
            temp.add(nums[i]);
            f(nums,target,i,sum+nums[i],temp); // Take it 
            temp.remove(temp.size()-1);
        }

    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        if(nums.length==0||target==0)
        return result ;
        else 
        {
            List<Integer> temp = new ArrayList<>();
            f(nums,target,0,0,temp);
            return result ;
        }
    }
}
