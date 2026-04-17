class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedHashSet<List<Integer>> map = new LinkedHashSet<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++)
        {
            int j = i +1;
            int k = nums.length -1 ;
            while(j<k)
            {
                if(nums[i] + nums[j] + nums[k]==0)
                {
                map.add(new ArrayList<>(Arrays.asList(nums[i],nums[j],nums[k])));
                j++; k--;
                }
                else if(nums[i] + nums[j] + nums[k] < 0)
                j++;
                else
                k--;
            }
        }
        return new LinkedList<>(map);
    }
}
