class Twitter {
    
    public class Tweet
	{
	int user ;
	int tweetId; 
	int priority ;
	Tweet(int user , int tweetId , int priority )
	{
	this.user = user ;
	this.tweetId = tweetId ;
	this.priority = priority ;
	}
	}
    int counter = 0;
    HashMap<Integer,HashSet<Integer>> followers ;
    HashMap<Integer,PriorityQueue<Tweet > > pqMap;

    public Twitter() {
        followers = new HashMap<>();
        pqMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        if(!pqMap.containsKey(userId))
        {
            PriorityQueue<Tweet> pq = new PriorityQueue<>((a,b)->b.priority-a.priority);
            pq.add(new Tweet(userId,tweetId,counter));
            pqMap.put(userId,pq);
        }
        else
        {

           PriorityQueue<Tweet> pq = pqMap.get(userId);
            pq.add(new Tweet(userId,tweetId,counter)); 
            pqMap.put(userId,pq);
        }
        counter ++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>() ;
        // PriorityQueue<Tweet> result_pq = new PriorityQueue<>(pqMap.get(userId)) ;

        PriorityQueue<Tweet> result_pq = new PriorityQueue<>(
    (a,b) -> b.priority - a.priority
);

if(pqMap.containsKey(userId))
    result_pq.addAll(pqMap.get(userId));
        
        if(followers.containsKey(userId))
        {
            HashSet<Integer> neigh = followers.get(userId) ;
            for(int x :neigh)
            {
                if(pqMap.containsKey(x)&& x!=userId )
                {
                PriorityQueue<Tweet> temp = new PriorityQueue<>(pqMap.get(x)) ;
                result_pq.addAll(temp);
                }
            }
        }
        int k = 10;
        while(!result_pq.isEmpty() && k-- > 0)
        result.add(result_pq.poll().tweetId);
        return result ;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!followers.containsKey(followerId))
        {
        HashSet<Integer> follow = new HashSet<>();
        follow.add(followeeId);
        followers.put(followerId,follow);
        }
        else
        {
        HashSet<Integer> follow = followers.get(followerId);
        follow.add(followeeId);
        followers.put(followerId,follow);
        }
    }
    
    public void unfollow(int followerId, int followeeId) {
        HashSet<Integer> follow = followers.get(followerId);
        follow.remove(followeeId) ;
        followers.put(followerId,follow);
    }
}
