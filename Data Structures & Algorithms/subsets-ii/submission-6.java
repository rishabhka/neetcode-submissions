class Solution {
    public void dfs(int [] nums,int i,List<Integer> temp,HashSet<List<Integer>> res)
    {
        res.add(new ArrayList<>(temp)) ;
        for(int j=i;j<nums.length;j++)
        {
            temp.add(nums[j]);
            dfs(nums,j+1,temp,res) ;
            temp.remove(temp.size()-1) ;
        }

    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        HashSet<List<Integer>> res = new HashSet<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(nums) ;
        dfs(nums,0,temp,res) ;
        return new ArrayList<>(res) ;
    }
}
