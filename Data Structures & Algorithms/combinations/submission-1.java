class Solution {
    public void f(int n,int k,List<List<Integer>> result,int i,List<Integer> temp,int j)
    {
        if(i==k)
        {
            result.add(new ArrayList<>(temp));
            return ;
        }
        else if(i>k||j>n)
        return ;
        else
        {
            f(n,k,result,i,temp,j+1); //skip
            temp.add(j);
            f(n,k,result,i+1,temp,j+1); //take
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        f(n,k,result,0,temp,1);
        return result ;
    }
}