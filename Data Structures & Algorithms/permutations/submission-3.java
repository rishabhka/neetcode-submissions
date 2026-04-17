class Solution {
    public void swap(int[] nums,int i, int j)
    {
        int temp = nums[i];
        nums[i]= nums[j];
        nums[j]= temp;

    }
    public void f(int[] nums,List<List<Integer>> result,List<Integer> temp,int i)
    {
        if(i==nums.length)
        {
        result.add(
           Arrays.stream(nums)
          .boxed()
          .toList()
         );
        }
        else
        {
            for(int j=i;j<nums.length;j++)
            {
                swap(nums,i,j);
                f(nums,result,temp,i+1);
                swap(nums,i,j);
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        f(nums,result,temp,0);
        return result ;
    }
}
