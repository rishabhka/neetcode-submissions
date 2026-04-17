class Solution {

    public void f(int [] nums,int i,HashSet<List<Integer>>  result,List<Integer> temp)
    {
        if(i==nums.length)
        {
            List<Integer> temp1 = new ArrayList<>(temp) ;
            Collections.sort(temp1) ;
            result.add(temp1);
        }
        else
        {
                temp.add(nums[i]);
                f(nums,i+1,result,temp); // Take it 
                temp.remove(temp.size()-1);
                f(nums,i+1,result,temp);   // skip it
            
        }

    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        HashSet<List<Integer>> result = new HashSet<>();
        List<Integer> temp = new ArrayList<>();
        f(nums,0,result,temp);
        return new ArrayList<>(result);
    }
}
