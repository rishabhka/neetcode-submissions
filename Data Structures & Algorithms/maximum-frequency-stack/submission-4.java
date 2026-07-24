class FreqStack {
    PriorityQueue<int[]> pq ; int idx = 0;
    HashMap<Integer,Integer> map ;
    public FreqStack() {
        pq = new PriorityQueue<>((a,b)-> //(nums,idx,count)
        {
            if(a[2]==b[2]) return Integer.compare(b[1],a[1]);
            else return Integer.compare(b[2],a[2]);
        });
        map = new HashMap<>();
    }
    
    public void push(int val) {
        map.put(val,map.getOrDefault(val,0)+1) ;
        pq.offer(new int[]{val,idx,map.get(val)});
        idx++;
    }
    
    public int pop() {
        int [] node = pq.poll();
        map.put(node[0],map.get(node[0])-1) ;
        return node[0] ;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */