class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums); 
        List<List<Integer>> res = new ArrayList<>();
        HashSet<List<Integer>> set = new HashSet<>();
        for(int i=0;i<nums.length;i++)
        {
            int j = i + 1; int k = nums.length-1 ; int sum = 0;
            while(j<k)
            {
                sum = nums[i] + nums[j] + nums[k] ;
                if(sum ==0) { set.add(Arrays.asList(nums[i],nums[j],nums[k]));
                k-- ; }
                else if(sum< 0)
                j++;
                else 
                k--;      
            }
        }
        return new ArrayList<>(set) ;
    }
}
