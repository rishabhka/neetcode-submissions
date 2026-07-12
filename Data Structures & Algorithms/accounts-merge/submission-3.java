class Solution {
    class UnionFind
    {
        int [] parent ;
        int [] rank ;
        UnionFind(int n) { this.parent = new int[n];
        this.rank = new int[n]; }
        public int find(int x)
        {
            if(x==parent[x])
            return parent[x] ;
            else return find(parent[x]);
        }
        public void union (int a , int b)
        {
            int x = find(a);
            int y = find(b);
            // if(a==b) // dont do anything
            if(rank[x]==rank[y])
            {
                rank[x]++;
            }
            if(rank[x]>rank[y])
            parent[y] = x;
            else 
            parent[x] = y;
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<Integer,String> idToName = new HashMap<>();
        HashMap<String,Integer> mailToIDX = new HashMap<>();
        HashMap<Integer,String> iDXTomail = new HashMap<>();
        List<List<String>>  res = new ArrayList<>();
        int count =0 ;
        for(int i=0;i<accounts.size();i++)
        {
            for(int j=1;j<accounts.get(i).size();j++)
            {
                if(!mailToIDX.containsKey(accounts.get(i).get(j)))
                {
                mailToIDX.put(accounts.get(i).get(j),count);
                iDXTomail.put(count,accounts.get(i).get(j));
                idToName.put(count,accounts.get(i).get(0));
                count++;
                }
            } 
        }
        int n = mailToIDX.size();
        UnionFind uf = new UnionFind(n);

        for(int i=0;i<n;i++)
        {
            uf.parent[i] =i ;
            uf.rank[i] = 1;
        }

        for(int i=0;i<accounts.size();i++)
        {
            int nodeA = mailToIDX.get(accounts.get(i).get(1));
            for(int j=2;j<accounts.get(i).size();j++)
            {
                int nodeB = mailToIDX.get(accounts.get(i).get(j));
                uf.union(nodeA,nodeB);
            }
        }
        HashMap<Integer,List<String>> pareToList = new HashMap<>();
        for(int i=0;i<n;i++)
        {
            if(!pareToList.containsKey(uf.find(uf.parent[i])))
            {
                pareToList.put(uf.find(uf.parent[i]),new ArrayList<>());
                String name = idToName.get(uf.find(uf.parent[i])) ;
                pareToList.get(uf.find(uf.parent[i])).add(name) ;
            }
            pareToList.get(uf.find(uf.parent[i])).add(iDXTomail.get(i)) ;
        }
        pareToList.forEach((a,b)->
        {
            Collections.sort(b.subList(1,b.size()));
            res.add(new ArrayList<>(b));
        });
        return res ;
    }
}