class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        if(n==0||n==1)
        return n;
        for(int i : nums)
        set.add(i);
        int len = 0;
        for(int i=0;i<n;i++)
        {
            int local_l =0;
            int next = nums[i] + 1;
          while(set.contains(next))
          {
            local_l++;
            if(local_l>len)
            len = local_l;
            next = next +1;
          }
        }
        return len+1;

    }
}
