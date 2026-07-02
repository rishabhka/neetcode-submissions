class TimeMap {
    class Node
    {
        String value ;
        int time;
        Node(int time,String value)
        {
            this.time = time;
            this.value = value;
        }
    }
    HashMap<String,ArrayList<Node>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key))
        map.put(key,new ArrayList<>());
        map.get(key).add(new Node(timestamp,value));
    }
    int idx =-1;
    public int binarySearch(List<Node> list,int i, int j ,int timestamp)
    {
        if(i>j) return idx;
        else
        {
            int mid = (j-i)/2+i;
            if(list.get(mid).time==timestamp) 
            {
                idx=mid;
                return mid ;
            }
            if(list.get(mid).time>timestamp) // go left
            return binarySearch(list,i,mid-1, timestamp);
            else
            {
            idx = mid ;
            return binarySearch(list,mid+1,j, timestamp);
            }
        }

    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";
        List<Node> list = map.get(key); 
        idx =-1;
        binarySearch(list,0,list.size()-1, timestamp);

        if(idx==-1) return "";
        else return list.get(idx).value ;

    }
}
