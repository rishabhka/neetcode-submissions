class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);

        for(int stone:stones)
        pq.add(stone);

        while(pq.size()>1)
        {
            int stone1 = pq.poll();
            int stone2 = pq.poll();
            int diff = Math.abs(stone1-stone2);
            if(diff!=0)
            pq.add(diff);
        }
        if(pq.size()==2)
        return Math.abs(pq.poll()-pq.poll());
        else if(pq.size()==1)
        return pq.poll();
        else return 0;
    }
}
