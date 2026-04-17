class Solution {
    public void f(int [] nums,int i,HashSet<List<Integer>>  result,List<Integer> temp)
    {
        if(i==nums.length-1)
        {
            result.add(new ArrayList<>(temp));
        }
        else
        {
            for(int j=i+1;j<nums.length;j++)
            {
                temp.add(nums[j]);
                f(nums,j,result,temp); // Take it 
                temp.remove(temp.size()-1);
                f(nums,j,result,temp);   // skip it
            }
        }

    }
    public List<List<Integer>> subsets(int[] nums) {
        HashSet<List<Integer>> result = new HashSet<>();
        List<Integer> temp = new ArrayList<>();
        f(nums,-1,result,temp);
        return new ArrayList<>(result);
    }
}
