class Solution {
    int [] rank ;
    int [] parent ;
    public int findParent(int x)
    {
        if(x==parent[x]) return x ;
        else return findParent(parent[x]) ;
    }
    public boolean union(int p,int q)
    {
        int parP = findParent(p);
        int parQ= findParent(q);
        if(parP==parQ) return true;
        if(rank[parP]==rank[parQ] )
        rank[parP] ++ ;
        if(rank[parP]>rank[parQ])
        parent[parQ]=parent[parP] ;
        else
        parent[parP]=parent[parQ] ;
        return false;
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> res = new ArrayList<>();
        HashMap<Integer,String> nodeToemail = new HashMap<>(); int k =0 ;
        HashMap<String,Integer> emailToNode = new HashMap<>(); 
        HashMap<Integer,List<String>> finalList = new HashMap<>(); 
        HashMap<String,String> emailToName = new HashMap<>(); 
        
        for(int i=0;i<accounts.size();i++)
        {
            for(int j=1;j<accounts.get(i).size();j++)
            {
                if(!emailToNode.containsKey(accounts.get(i).get(j)))
                {
                emailToName.put(accounts.get(i).get(j),accounts.get(i).get(0)) ;
                nodeToemail.put(k,accounts.get(i).get(j)) ;
                emailToNode.put(accounts.get(i).get(j),k) ;
                k++;
                }
            }
        }
        rank = new int[nodeToemail.size()];
        parent= new int[nodeToemail.size()];
        for(int i=0;i<nodeToemail.size();i++)
        {
            rank[i] = 1;
            parent[i] = i;
        }
        for(int i=0;i<accounts.size();i++)
        {
            for(int j=2;j<accounts.get(i).size()&&accounts.get(i).size()>1;j++)
            {
                Integer a = emailToNode.get(accounts.get(i).get(j));
Integer b = emailToNode.get(accounts.get(i).get(j-1));
                if (a == null || b == null) {
    System.out.println("MISSING: " + accounts.get(i).get(j) + " / " + accounts.get(i).get(j-1));
}
                union(emailToNode.get(accounts.get(i).get(j)),emailToNode.get(accounts.get(i).get(j-1))) ;
            }
        }
        for(int i=0;i<parent.length;i++)
        {
            int parX = findParent(i) ;
            if(!finalList.containsKey(parX))
            finalList.put(parX,new ArrayList<>()) ;
            finalList.get(parX).add(nodeToemail.get(i)) ; 
        }
        finalList.forEach((key,value)->
        {
            List<String> temp = new ArrayList<>();
            temp.add(emailToName.get(nodeToemail.get(key))) ;
            Collections.sort(value) ;
            temp.addAll(value) ;
            res.add(temp) ;
        }) ;
        return res ;

    }
}