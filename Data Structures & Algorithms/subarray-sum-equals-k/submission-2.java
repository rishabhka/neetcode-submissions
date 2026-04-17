//[2,-1,1,2]
// 2  1  2  4
class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length ;
        int [] prefix = new int [n];
        prefix[0] = nums[0] ;
        int count =0 ; int prev =0 ;
        for(int i=1;i<n;i++)
        {
            prefix[i] = prefix[i-1] + nums[i] ;
        }
        
        HashMap<Integer,Integer> map = new HashMap<>() ;
        map.put(0,1) ;
        for(int value: prefix)
        {
            // System.out.print÷ln(value);
            if(map.containsKey(value-k))
            {
                int x = map.get(value-k) ;
                // System.out.println("x");
                count = count + x ;
            }
            map.put(value,map.getOrDefault(value,0)+1) ;
        }
        // System.out.println(map.size());
        return count ;
    }
}