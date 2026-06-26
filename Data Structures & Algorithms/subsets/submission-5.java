class Solution {
    public void f(int[] nums,int i , List<List<Integer>> result ,List<Integer> temp)
    {
        
        result.add(new ArrayList<>(temp));
        for(int j=i;j<nums.length;j++)
        {
            temp.add(nums[j]);
            f(nums,j+1,result,temp);
            temp.remove(temp.size()-1);
        }

    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        f(nums,0,result,temp);
        return result;
    }
}
