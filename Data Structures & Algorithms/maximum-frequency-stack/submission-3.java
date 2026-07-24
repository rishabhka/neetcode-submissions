class FreqStack {
    HashMap<Integer,Integer> freq ;
    HashMap<Integer,Deque<Integer>> map ; int max_freq = 0;
    public FreqStack() {
        freq = new HashMap<>();
        map = new HashMap<>();
    }
    
    public void push(int val) {
        freq.put(val,freq.getOrDefault(val,0)+1) ;
        if(freq.get(val)>max_freq) max_freq = freq.get(val);
        if(!map.containsKey(freq.get(val)))
        map.put(freq.get(val),new ArrayDeque<>());
        map.get(freq.get(val)).push(val) ;
    }
    
    public int pop() {
        int popped_el = map.get(max_freq).poll();
        if(map.get(max_freq).size()==0)
        {
        map.remove(max_freq) ; max_freq--;
        }
        freq.put(popped_el,freq.get(popped_el)-1) ;
        return popped_el ;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */