class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int max_len =0;
        for(int num:nums)
        set.add(num);

        for(int num:nums)
        {
            int local_len =0;
            if(set.contains(num))
            local_len++;
            if(set.contains(num-1))
            continue ;
            while(set.contains(num+1))
            {
                local_len++;
                num = num+1;
            }
            if(local_len>max_len)
            max_len=local_len;
        }

        return max_len;
    }
}
