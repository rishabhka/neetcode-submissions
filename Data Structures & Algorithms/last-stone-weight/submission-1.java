class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->(b-a));
        for(int i:stones)
        pq.add(i);

        while(pq.size()>2)
        {
            int x = pq.poll();
            int y = pq.poll();
            if(x==y)
            continue ;
            else pq.add(Math.abs(x-y));

        }
        if(pq.size()==2)
        return Math.abs(pq.poll()-pq.poll());
        else
        return pq.poll();
    }
}
