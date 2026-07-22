class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums); 
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<nums.length;i++)
        {
            int j = i + 1; int k = nums.length-1 ; int sum = 0;
            if(i-1>=0&&nums[i]==nums[i-1]) continue ;
            
            while(j<k)
            {
                sum = nums[i] + nums[j] + nums[k] ;
                if(sum ==0) { res.add(Arrays.asList(nums[i],nums[j],nums[k]));
                k-- ;
                while(j<k&&k+1<nums.length&&nums[k]==nums[k+1]) k--;
                while(j<k&&nums[j]==nums[j+1]) j++;      
                }
                else if(sum< 0)
                j++;
                else 
                k--; 
                
            }
        }
        return res ;
    }
}
