class Solution {
    public int[] twoSum(int[] nums, int target) {
        int [] result = new int [2];
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        for(int i=0;i<n;i++)
        {
            if(map.containsKey(target-nums[i]))
            {
                result[0] = map.get(target-nums[i]);
                result[1] = i;
            }
            else
            map.put(nums[i],i);
        }
        return result;
    }
}
