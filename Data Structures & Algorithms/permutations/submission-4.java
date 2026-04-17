class Solution {
    public void swap(int [] nums , int i , int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp ;
    }
    public void f(int[] nums,int i,List<List<Integer>> result,List<Integer> temp)
    {
        if(i>nums.length)
        return ;
        if(i==nums.length)
        {
            result.add(Arrays.stream(nums)
               .boxed()
               .collect(Collectors.toList()));
        }
        for(int j=i;j<nums.length;j++)
        {
            swap(nums,i,j) ;
            // temp.add(nums[j]);
            f(nums,i+1,result,temp);
            swap(nums,j,i) ;
            // temp.remove(temp.size()-1);
        }

    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        f(nums,0,result,temp);
        return result ;
    }
}
