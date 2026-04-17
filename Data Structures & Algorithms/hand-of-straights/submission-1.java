class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        
       
        List<HashSet<Integer>> listSet= new ArrayList<>();


        if(hand.length%groupSize!=0)
        return false;

        int [] prev = new int [hand.length/groupSize] ;
        Arrays.fill(prev,-1) ;

        Arrays.sort(hand);

        for(int i=0;i<hand.length/groupSize;i++)
        {
            listSet.add(new HashSet<>());
        }

        for(int i=0;i<hand.length;i++)
        {
            boolean flag = false ;
            for(int j=0;j<listSet.size();j++)
            {
            HashSet<Integer> set_a =  listSet.get(j) ;
            if((set_a.size()<groupSize && (prev[j]+1) ==hand[i])||(prev[j]==-1))
            {
            System.out.println(hand[i]+ " "+j);
            prev[j] = hand[i];
            set_a.add(hand[i]);
            flag = true ;
            break ;
            }
            }
             if(flag==false)
            return false;
        }

        

        // for(int i=hand.length/groupSize;i<hand.length;i++)
        // {
        //     boolean flag = false;
        //     for(int j=0;j<listSet.size();j++)
        //     {
        //     HashSet<Integer> set_a =  listSet.get(j) ;
        //     if(set_a.size()<groupSize && (prev[j]+1) ==hand[i])
        //     {
        //     prev[j] = hand[i];
        //     set_a.add(hand[i]);
        //     flag = true ;
        //     break ;
        //     }
        //     }
        //     if(flag==false)
        //     return false;
        // }
        return true ;

    }
}
