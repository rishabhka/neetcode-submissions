class Solution {
    public int[] twoSum(int[] nums, int target) {
        int p =0 ; int q= nums.length -1 ; 
        while(p<q)
        {
            int sum = nums[p] + nums[q] ;
            if(target == sum ) return new int [] {p+1,q+1};
            if(target > sum )
            p++;
            else
            q--;
        }
        return new int[2] ;
    }
}
