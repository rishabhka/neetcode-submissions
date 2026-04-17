class Solution {
    public void sub(int [] nums , int i,List<List<Integer>> finalList,List<Integer> list)
    {
        if(i==nums.length)
        {
        finalList.add(new ArrayList<>(list));
        return ;
        }
        else
        {
            List <Integer> temp = new ArrayList<>(list);
            sub(nums,i+1,finalList,temp);
            temp.add(nums[i]);
            sub(nums,i+1,finalList,temp);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer> > finalList = new ArrayList<>();
        List<Integer> list = Collections.emptyList();
        sub(nums,0,finalList,list);
        for(List<Integer> lis1:finalList)
        Collections.sort(lis1);
        return new ArrayList<>(new LinkedHashSet<>(finalList));
    }
}
