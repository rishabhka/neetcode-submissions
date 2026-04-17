class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public void f(int [] nums,int i,List<Integer> temp)
    {
        if(i==nums.length)
        {
            result.add(new ArrayList<>(temp));
        }
        else
        {
            //take it
            temp.add(nums[i]);
            f(nums,i+1,temp);
            temp.remove(temp.size()-1);
            //Skip it 
            f(nums,i+1,temp);
        }

    }
    public List<List<Integer>> subsets(int[] nums) {
        if(nums.length==0)
        return result ;
        else
        {     
            List<Integer> temp = new ArrayList<>();
            f(nums,0,temp);   
            return result ;
        }
    }
}
