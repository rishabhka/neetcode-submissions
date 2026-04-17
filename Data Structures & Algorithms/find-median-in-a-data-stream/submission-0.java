class MedianFinder {
    PriorityQueue<Integer> maxheap ;
    PriorityQueue<Integer> minheap ;
    public MedianFinder() {
        maxheap = new PriorityQueue<>((a,b)->(b-a)); // to store 1 to n-1/2
        minheap = new PriorityQueue<>();  // to store n-1/2+1 to n
    }
    //max 1
    //min 2
    public void addNum(int num) {
        if(minheap.size()==0&&maxheap.size()==0)
        {
        maxheap.add(num);
        return ;
        }

        if(num>=maxheap.peek())
        {
            minheap.add(num);
            if(minheap.size()-maxheap.size()>1)
            {
             maxheap.add(minheap.poll()) ;
            }        
            
        }
        else 
        {
            
            maxheap.add(num);
            if(maxheap.size()-minheap.size()>1)
            {
             minheap.add(maxheap.poll()) ;
            }
        }
    }
    
    public double findMedian() {
        if(maxheap.size()==minheap.size())
        {
            System.out.println(maxheap.peek()+" "+minheap.peek()) ;
        return ((double)(maxheap.peek()+minheap.peek())/2);
        }
        else if(maxheap.size()>minheap.size())
        return maxheap.peek() ;
        else return minheap.peek() ;
    }
}
