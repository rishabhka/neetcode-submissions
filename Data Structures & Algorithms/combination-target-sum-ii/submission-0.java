class Solution {
    public List<List<Integer>> backtrack(int[] candidates,int target,List<List<Integer>> list,int i ,int sum,List<Integer> temp)
    {
        if (sum == target) {
            list.add(new ArrayList<>(temp));
            return list; // stop exploring further
        }
        else if(i>=candidates.length|| sum > target)
        return list ;
        else
        {
            if(sum+candidates[i]<=target)
            {
                temp.add(candidates[i]);
                backtrack(candidates,target,list,i+1 ,sum+candidates[i],temp);
                temp.remove(temp.size() - 1);
                while((i+1<candidates.length)&&(candidates[i]==candidates[i+1]))
                i++;
                backtrack(candidates,target,list,i+1 ,sum,temp);
            }
            
        }

return list ;
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backtrack(candidates,target,list,0,0,temp);
        return new ArrayList<>(new LinkedHashSet<>(list)) ;
    }
}
