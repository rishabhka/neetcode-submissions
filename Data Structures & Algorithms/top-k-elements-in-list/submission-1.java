class Solution {

    public class Node
    {
        int value ;
        int count ;
    }
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer,Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for(int i : nums)
        map.put(i,map.getOrDefault(i,0)+1);

        PriorityQueue<Node> pq = new PriorityQueue<>(
            new Comparator<Node>()
            {
                public int compare(Node a , Node b)
                {
                    return Integer.compare(b.count,a.count);
                }
            }
        );
        for(int key : map.keySet())
        {
            Node node = new Node();
            node.value = key ;
            node.count = map.get(key) ;
            pq.add(node);
        }
        while(k!=0)
        {
            int x = pq.poll().value;
            System.out.println(x);
            result.add(x);
            k--;
        }
        int size = result.size();
        System.out.println(size);
        int [] final1 = new int [size] ;
        for(int i=0;i<size;i++)
        final1[i] = result.get(i);
        return final1;

        
    }
}
