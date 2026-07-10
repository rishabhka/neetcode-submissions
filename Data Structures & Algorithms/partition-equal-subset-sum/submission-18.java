class Solution {
    public boolean canPartition(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int target =0;
        for(int i=0;i<nums.length;i++)
        target = target + nums[i];
        if(target%2!=0) return false;
        target = target /2 ;
        set.add(0);
        for(int i=nums.length-1;i>=0;i--)
        {
            Iterator<Integer> it = set.iterator();
            List<Integer> list = new ArrayList<>();
            while(it.hasNext())
            {
                int val = it.next();
                if(nums[i]+val==target)
                return true ;
                else list.add(nums[i]+val);
            }
            set.addAll(list);
        }
        return false; 
    }
}
