class Solution {

    public void sub(int[] nums,int i,List<List<Integer>> res,List<Integer> temp,int target)
    {
        if(target ==0) { res.add(new ArrayList<>(temp)); return ; }
        if(i==nums.length||target<0) {
            return  ;
        }
        temp.add(nums[i]) ;
        sub(nums,i,res,temp,target-nums[i]) ;
        temp.remove(temp.size()-1) ;
        sub(nums,i+1,res,temp,target) ;

    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        sub(nums,0,res,temp,target) ;
        return res ;
    }
}
