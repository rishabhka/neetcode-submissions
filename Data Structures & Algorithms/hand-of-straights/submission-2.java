class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        HashMap<Integer,Integer> map = new HashMap<>();
        if(hand.length%groupSize!=0)
        return false ;
        for(int card : hand)
        map.put(card,map.getOrDefault(card,0)+1);
        Arrays.sort(hand) ;
        for(int card : hand)
        {
            if(map.containsKey(card))
            {
            // Create group 
            for(int j=0;j<groupSize;j++)
            {
                int newValue = card + j ;
                if(!map.containsKey(newValue))
                return false ; 
                if(map.get(newValue)-1==0)
                map.remove(newValue) ;
                else
                map.put(newValue,map.get(newValue)-1);
            }
            }
        }
        return true ;

    }
}
