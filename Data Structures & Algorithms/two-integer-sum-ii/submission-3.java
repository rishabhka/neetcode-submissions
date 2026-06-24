class Solution {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer,Integer> set = new HashMap<>();

        for(int i=0;i<numbers.length;i++)
        {
            if(set.containsKey(numbers[i]))
            {
            int [] s = new int[]{set.get(numbers[i])+1,i+1};
            Arrays.sort(s);
            return s;
            }
            else
            set.put(target-numbers[i],i);
        }

        return new int[2];
        
    }
}
