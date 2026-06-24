class Solution {
    public class Tuple
    {
        int key ;
        int count ;
        Tuple(int k,int c)
        {
            key = k;
            count = c;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int [] result = new int [k];
        for(int i=0;i<nums.length;i++)
          map.put(nums[i],map.getOrDefault(nums[i],1)+1);
        List<Tuple> list = new ArrayList<>();
        map.forEach((key,val)->
        {
            list.add(new Tuple(key,val));
        });
        Collections.sort(list,(a,b)->Integer.compare(b.count,a.count));
        for(int i=0;i<k;i++)
        result[i] = list.get(i).key;
        return result ;
    }
}
