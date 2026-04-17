class Solution {
    public void sub(int [] nums,List<List<Integer>> result,List<Integer> temp,int i)
    {
        if(i==nums.length)
        {
            result.add(new ArrayList<>(temp));
            return ;
        }
        sub(nums,result,temp,i+1) ;
        temp.add(nums[i]);
        sub(nums,result,temp,i+1) ;
        temp.remove(temp.size()-1);

    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        sub(nums,result,temp,0);
        return result ;
    }
}
