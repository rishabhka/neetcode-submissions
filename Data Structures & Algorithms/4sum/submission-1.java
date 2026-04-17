class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedHashSet<List<Integer>> map = new LinkedHashSet<>();
        Arrays.sort(nums);
        for(int p=0;p<nums.length;p++)
        {
        for(int i=p+1;i<nums.length;i++)
        {
            int j = i +1;
            int k = nums.length -1 ;
            while(j<k)
            {
                if((long)nums[i] + (long)nums[j] + (long)nums[k] + (long)nums[p]==(long)target)
                {
                List<Integer> temp = new ArrayList<>(Arrays.asList(nums[i],nums[j],nums[k],nums[p]));
                Collections.sort(temp);
                map.add(temp);
                j++; k--;
                }
                else if(nums[i] + nums[j] + nums[k]+ nums[p] < target)
                j++;
                else
                k--;
            }
        }
        }
        return new LinkedList<>(map);
    }
}