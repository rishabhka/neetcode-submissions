class Solution {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer> > result = new ArrayList<>();
        if(nums.length==0)
        return Collections.emptyList() ;
        else if(nums.length==1)
        {
            // List<Integer> list =new ArrayList<>(Arrays.asList(nums[0]));
            return Collections.singletonList(Collections.singletonList(nums[0]));
        } 
        else
        {  //3
            List<List<Integer> > list = permute(Arrays.copyOfRange(nums,1,nums.length));
            List<List<Integer> > x = new ArrayList<>();
            for(int i=0;i<list.size();i++)
            {
                
                for(int j=0;j<=list.get(i).size();j++)
                {
                  List<Integer> temp = new ArrayList<>(list.get(i));
                  temp.add(j,nums[0]);
                  x.add(temp);
                }
                
            }
            return x ;
        }
    }
}
