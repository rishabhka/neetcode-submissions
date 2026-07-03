class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        HashMap<Integer,Integer> map = new HashMap<>();
        if(hand.length%groupSize!=0) return false;
        Arrays.sort(hand);
        for(int i=0;i<hand.length;i++)
        map.put(hand[i],map.getOrDefault(hand[i],0)+1);

        for(int i=0;i<hand.length;i++)
        { 
            if(map.get(hand[i])==0) continue ;
            else
            {
            int small = hand[i];
            int large =hand[i]+groupSize;
            for(int j=small;j<large;j++)
            {
                if(!map.containsKey(j)) return false;
                else if(map.get(j)==0) return false;
                else map.put(j,map.get(j)-1);
            }
            }
        }
        return true;
    }
}
