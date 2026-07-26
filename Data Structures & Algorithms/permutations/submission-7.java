class Solution {
    public void swap(int [] nums,int i,int j)
    {
        int temp = nums[i] ;
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void sub(int[] nums,int i,List<List<Integer>> res,List<Integer> temp)
    {
        if(i==nums.length) {
            res.add(new ArrayList<>(temp));
        }
        for(int j= i ;j<nums.length;j++)
        {
            //take it 
            temp.add(nums[j]) ;
            swap(nums,i,j) ;
            sub(nums,i+1,res,temp) ;
            temp.remove(temp.size()-1) ;
            swap(nums,i,j) ;
        }

    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        sub(nums,0,res,temp) ;
        return res ;
    }
}
