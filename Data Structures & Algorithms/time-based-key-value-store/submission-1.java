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
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";
        List<Node> list = map.get(key); int small=-1;
        for(int i=0;i<list.size();i++)
        {
            Node node = list.get(i);
            if(node.time==timestamp) return node.value;
            else if(node.time<timestamp)
            small = i;
        }
        if(small==-1) return "";
        else
        return list.get(small).value;
    }
}
