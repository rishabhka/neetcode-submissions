class FreqStack {
    class Node
    {
        int key;
        int freq;
        int idx ;
        Node(int key , int freq,int idx)
        {
            this.key = key;
            this.freq=freq;
            this.idx=idx ;
        }
    }
    int time = 0;
    HashMap<Integer,Integer> map ; //(key,freq)
    PriorityQueue<Node> pq ;
    public FreqStack() {
        map = new HashMap<>();
        pq = new PriorityQueue<>(
            (a,b) ->
            {
            if(a.freq==b.freq) return Integer.compare(b.idx,a.idx);
            else return Integer.compare(b.freq,a.freq);
            }
        ) ;
    }
    
    public void push(int val) {
        map.put(val,map.getOrDefault(val,0)+1);
        pq.offer(new Node(val,map.get(val),time));
        time++;
    }
    
    public int pop() {
        Node node = pq.poll();
        map.put(node.key,map.get(node.key)-1);
        return node.key;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */