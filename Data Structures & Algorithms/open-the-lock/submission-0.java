class Solution {
    int min = Integer.MAX_VALUE;

    public int openLock(String[] deadends, String target) {
        if(target.equals("0000")) return 0;
        HashSet<String> deadendset = new HashSet<>();
        HashSet<String> visited = new HashSet<>();
        Queue<int []> q = new LinkedList<>();
        q.add(new int [] {0, 0,0,0,0});
        for(String s : deadends)
        {
            deadendset.add(s);
        }
        while(!q.isEmpty())
        {
            int [] node = q.poll(); 
            char [] nodechar = new char [] {(char)(node[0]+'0'), (char)(node[1]+'0'), (char)(node[2]+'0'), (char)(node[3]+'0')};
            String curr = new String(nodechar);
            if(deadendset.contains(curr)) continue;
            if(visited.contains(curr)) continue;
            visited.add(curr);
            if(curr.equals(target)) return node[4];
            node[4]++;
            for(int i=0;i<4;i++)
            {
                int up = (node[i]+1)%10;
                int down = (node[i]-1+10)%10;
                int original = node[i];
                node[i]= up ;
                q.add(node.clone());
                node[i]= down ;
                q.add(node.clone());
                node[i]= original;
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
