class Solution {
    public class Node
    {
        int i ;
        List<Node> list = new ArrayList<>();
        Node(int _i)
        {
            i = _i ;
        }
    }
    public boolean validTree(int n, int[][] edges) {
         int m = edges.length;
         if(m>=n)
         return false;
         else
         {
            HashMap<Integer,Node> map = new HashMap<>();
            for(int i=0;i<n;i++)
            {
                map.put(i,new Node(i));
            }
            for(int i=0;i<edges.length;i++)
            {
                Node src = map.get(edges[i][0]);
                Node dest = map.get(edges[i][1]);
                src.list.add(dest);
                dest.list.add(src);
            }
            int count = 1;
            HashSet<Node> set = new HashSet<>();
            Queue<Node> q= new LinkedList<>();
            q.add(map.get(0));
            set.add(map.get(0));
            while(!q.isEmpty())
            {
              Node ele = q.poll();
              for(int i=0;i<ele.list.size();i++)
              {
                if(!set.contains(ele.list.get(i)))
                {
                    q.add(ele.list.get(i));
                    set.add(ele.list.get(i));
                    count ++;
                }
              }
            }
            System.out.print(count);
            if(count==n)
            return true;
            else return false;
         }
         
    }
}
