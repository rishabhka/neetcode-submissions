class Solution {
    int [] parent ;
    int [] rank ;
    public int checkParent(int node)
    {
        while(parent[node]!=node)
        node = parent[node];

        return node ;
    }
    public boolean Unionfind(int node1 ,int node2)
    {
        int x = checkParent(node1);
        int y = checkParent(node2);
        if(x==y)
        {
            return true ;
        }
        else
        {
            if(rank[x]>=rank[y])
            {
                rank[x]++;
                parent[y] = x ;
            }
            else
            {
                rank[y]++;
                parent[x] = y ;
            }
        }
        return false ;
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        List<List<String>> result  = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        HashMap<String,Integer> map = new HashMap<>();
        HashMap<String,String> emailToName = new HashMap<>();
        // Map<String, String> emailToName
        List<String> node = new ArrayList<>();
        int k =0;
        
        for(int i=0;i<accounts.size();i++)
        {
            String name = accounts.get(i).get(0);
            for(int j=1;j<accounts.get(i).size();j++)
            {
                if(!set.contains(accounts.get(i).get(j)))
                {
                set.add(accounts.get(i).get(j));
                node.add(accounts.get(i).get(j));
                map.put(accounts.get(i).get(j),k);
                emailToName.put(accounts.get(i).get(j),name);
                k++;
                }
            }
        }
        parent = new int[node.size()] ;
        rank = new int [node.size()] ;

        for(int i=0;i<node.size();i++)
        parent[i]=i;
        

        for(int i=0;i<accounts.size();i++)
        {
            String firstNode = accounts.get(i).get(1);
            for(int j=2;j<accounts.get(i).size();j++)
            {
                String nextNode = accounts.get(i).get(j);
                Unionfind(map.get(firstNode),map.get(nextNode));
            }
        }
        HashMap<Integer,List<String>> last = new HashMap<>();

        for(int i=0;i<node.size();i++)
        {
            int par = checkParent(i);
            if(!last.containsKey(par))
            last.put(par,new ArrayList<>());
            last.get(par).add(node.get(i));
        }

        for(List<String> list : last.values())
        {
            Collections.sort(list);
            String name = emailToName.get(list.get(0));
            List<String> temp = new ArrayList<>();
            temp.add(name);
            temp.addAll(list);
            result.add(temp);
        }
        return result ;
        

    }
}