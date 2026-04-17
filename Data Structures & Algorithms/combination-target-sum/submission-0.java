class Solution {

    public void f(int[] candidates,int target,int i ,int sum,List<List<Integer>> result,List<Integer> list)
    {
        if(target==sum)
        {
        result.add(new ArrayList<>(list));
        return ;
        }
        else if(sum>target||i>=candidates.length)
        return ;
        else
        {
            list.add(candidates[i]); 
            f(candidates,target,i,sum+candidates[i],result,list);
            list.remove(list.size() - 1);
            f(candidates,target,i+1,sum,result,list);
        }


    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        f(candidates,target,0,0,result,list);
        return result;
    }
}