class MedianFinder {
    PriorityQueue<Integer> maxheap;
    PriorityQueue<Integer> minheap;
    public MedianFinder() {
        maxheap= new PriorityQueue<>((a,b)-> {
            return Integer.compare(b,a) ;
        }) ;
        minheap= new PriorityQueue<>((a,b)-> {
            return Integer.compare(a,b) ;
        });
    }
    
    public void addNum(int nums) {
        if(minheap.isEmpty()&&maxheap.isEmpty()) { minheap.offer(nums) ; return ; }

        if(minheap.peek()>nums)
        {
            if(!maxheap.isEmpty()&&nums>maxheap.peek())
            minheap.offer(nums) ;
            else
            maxheap.offer(nums) ;         
        }
        else
        {
            minheap.offer(nums) ;
        }
        if(maxheap.size()>minheap.size()+1)
        {
        minheap.offer(maxheap.poll()) ;
        }
        else if(maxheap.size()+1<minheap.size())
        {
            maxheap.offer(minheap.poll()) ;
        }
    }
    
    public double findMedian() {
        if(maxheap.size()==minheap.size())
        return (double ) (minheap.peek()+maxheap.peek())/2 ;
        else 
        return minheap.size()>maxheap.size()?minheap.peek():maxheap.peek() ;
    }
}
