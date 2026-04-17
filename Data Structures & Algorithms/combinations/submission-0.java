class Solution {
    public void f(int[] nums,int i,int k,List<List<Integer>> result,List<Integer> temp)
    {
        if(temp.size()==k)
        {
            result.add(new ArrayList<>(temp));
        }
        else if(temp.size()>k || i>=nums.length)
        return ;
        else
        {
            temp.add(nums[i]);
            f(nums,i+1,k,result,temp);
            temp.remove(temp.size()-1);
            f(nums,i+1,k,result,temp);
        }

    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        int nums[] = new int [n];
        for(int i=1;i<=n;i++)
        nums[i-1] = i ;
        List<Integer> temp = new ArrayList<>();
        
        f(nums,0,k,result,temp);
        return new ArrayList<>(result) ;
    }
}