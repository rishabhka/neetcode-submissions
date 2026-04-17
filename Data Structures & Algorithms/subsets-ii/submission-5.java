class Solution {
    public void f(int [] nums,LinkedHashSet<List<Integer>> result,List<Integer> temp,int i)
    {
        if(nums.length==i)
        {
            List<Integer> nl = new ArrayList<>(temp) ;
            Collections.sort(nl);
            result.add(nl);
        }
        else
        {
            f(nums,result,temp,i+1); //skip it
            temp.add(nums[i]);
            f(nums,result,temp,i+1); // take it 
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        LinkedHashSet<List<Integer>> result = new LinkedHashSet<>();
        List<Integer> temp = new ArrayList<>();
        f(nums,result,temp,0);
        return new ArrayList<>(result) ;
    }
}
