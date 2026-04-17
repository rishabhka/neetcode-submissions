class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public void swap(List<Integer> nums,int i,int j) 
    {
        int temp = nums.get(i) ;
        nums.set(i,nums.get(j)) ;
        nums.set(j,temp);
    }
    public void perm(List<Integer> nums,int i)
    {
        if(i==nums.size()-1)
        {
        result.add(new LinkedList<>(nums));
        return ;
        }
        else
        {
            for(int j=i;j<nums.size();j++)
            {
                swap(nums,i,j) ;
                perm(nums,i+1);
                swap(nums,i,j) ;
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        for(int num:nums)
        temp.add(num);
        perm(temp,0);
        return result ;
    }
}
