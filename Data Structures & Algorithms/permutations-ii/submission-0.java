class Solution {
    public void swap(int[] nums,int i, int j)
    {
        int temp = nums[i];
        nums[i]= nums[j];
        nums[j]= temp;

    }
    public void f(int[] nums,HashSet<List<Integer>> result,List<Integer> temp,int i)
    {
        if(i==nums.length)
        {
            result.add(new ArrayList<>(temp));
        }
        else
        {
            for(int j=i;j<nums.length;j++)
            {
            swap(nums,i,j);
            temp.add(nums[i]);
            f(nums,result,temp,i+1);
            temp.remove(temp.size()-1);
            swap(nums,i,j);
            }

        }

    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        HashSet<List<Integer>> result = new HashSet<>();
        List<Integer> temp = new ArrayList<>();

        f(nums,result,temp,0);
        return new ArrayList<>(result) ;
    }
}