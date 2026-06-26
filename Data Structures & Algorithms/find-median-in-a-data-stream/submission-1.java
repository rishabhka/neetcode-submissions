class MedianFinder {
    PriorityQueue<Integer> min_heap ;
    PriorityQueue<Integer> max_heap ;
    public MedianFinder() {
       min_heap = new PriorityQueue<>();
    max_heap = new PriorityQueue<>((a,b)->Integer.compare(b,a)); 
    }
    
    public void addNum(int num) {
        if(min_heap.isEmpty())
        min_heap.add(num);
        else if(num>min_heap.peek())
        min_heap.add(num);
        else
        max_heap.add(num);

        if(Math.abs(max_heap.size()-min_heap.size())>1)
        {
            if(max_heap.size()>min_heap.size())
            {
                min_heap.add(max_heap.poll());
            }
            else 
            max_heap.add(min_heap.poll());   
        }
    }
    
    public double findMedian() {
        if(max_heap.size()>min_heap.size())
                return (max_heap.peek());
        else if(max_heap.size()<min_heap.size())
            return (min_heap.peek());
            else return (double) (min_heap.peek()+max_heap.peek())/2; 
               }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */