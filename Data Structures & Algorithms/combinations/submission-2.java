class Solution {
    public void comb(int n,int k,int i,List<Integer> temp)
    {
        if(temp.size()==k)
        {
            result.add(new ArrayList<>(temp));
            return ;
        }
        else if(i>n)
        return ;
        else
        {
                
                temp.add(i);
                comb(n,k,i+1,temp); //Take
                temp.remove(temp.size()-1);
                comb(n,k,i+1,temp); // skip
        }

    }
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> temp = new ArrayList<>();
        comb(n,k,1,temp);
        return result ;
    }
}