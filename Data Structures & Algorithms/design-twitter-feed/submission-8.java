class Twitter {
    HashMap<Integer,List<int [] > > map ; // (userId,tweet_id,time,idx)
    HashMap<Integer,HashSet<Integer> > follow ; int time =0 ;
    public Twitter() {
        map = new HashMap<>();
        follow = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        if(!map.containsKey(userId))
        map.put(userId,new ArrayList<>());
        map.get(userId).add(new int [] {userId,tweetId,time++, map.get(userId).size() }) ;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[] > pq = new PriorityQueue<>((a,b)->
        {
            return Integer.compare(b[2],a[2]) ;
        }) ;
        if(map.containsKey(userId)) 
        pq.offer(map.get(userId).get(map.get(userId).size()-1));
        HashSet<Integer> followers = follow.getOrDefault(userId,new HashSet<>()) ;
        followers.forEach((a)->
        {
            if(map.containsKey(a))
            pq.offer(map.get(a).get(map.get(a).size()-1));
        }) ;
        List<Integer> res = new ArrayList<>(); int i=0;
        while(!pq.isEmpty()&&i!=10)
        {
            int [] node = pq.poll();
            res.add(node[1]) ;
            if(node[3]-1>=0)
            {
            int idx = node[3] - 1 ;
            List<int []> list = map.get(node[0]) ;    
            pq.offer(map.get(node[0]).get(idx));
            }
            i++;
        }
        return res ;
    }
    
    public void follow(int followerId, int followeeId) {
        if(followerId==followeeId) return ;
        if(!follow.containsKey(followerId))
        follow.put(followerId,new HashSet<>());
        follow.get(followerId).add(followeeId) ;
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(follow.containsKey(followerId))
        follow.get(followerId).remove(followeeId) ;
    }
}
