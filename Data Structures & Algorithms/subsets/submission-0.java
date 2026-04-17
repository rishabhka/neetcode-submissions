class Solution {
    public void sub(int [] nums , int i,List<List<Integer>> finalList,List<Integer> list)
    {
        if(i==nums.length)
        {
        finalList.add(list);
        return ;
        }
        else
        {
            List <Integer> temp1 = new ArrayList<>(list);
            List <Integer> temp2 = new ArrayList<>(list);
            sub(nums,i+1,finalList,temp1);
            temp2.add(nums[i]);
            sub(nums,i+1,finalList,temp2);
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer> > finalList = new ArrayList<>();
        List<Integer> list = Collections.emptyList();
        sub(nums,0,finalList,list);
        return finalList;
    }
}
