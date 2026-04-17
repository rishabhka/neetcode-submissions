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
            result.add(new ArrayList<>(temp));
        }
        else
        {
            HashSet<Integer> set = new HashSet<>();
            for(int j=i;j<nums.length;j++)
            {
            if(set.contains(nums[j]))
            continue ;
            set.add(nums[j]);
            swap(nums,i,j);
            temp.add(nums[i]);
            f(nums,result,temp,i+1);
            temp.remove(temp.size()-1);
            swap(nums,i,j);
            }

        }

    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(nums);
        f(nums,result,temp,0);
        return result ;
    }
}