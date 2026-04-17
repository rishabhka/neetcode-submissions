class Solution {
    public boolean mergeTriplets(int[][] tripltes, int[] target) {
        List<List<Integer>>  trip = new ArrayList<>();
        int n = tripltes.length ;
        for(int i=0;i<n;i++)
        {
            if(tripltes[i][0]>target[0]||tripltes[i][1]>target[1]||tripltes[i][2]>target[2])
            continue ;
            if(tripltes[i][0]!=target[0]&&tripltes[i][1]!=target[1]&&tripltes[i][2]>target[2])
            continue ;
            else trip.add(Arrays.asList(tripltes[i][0],tripltes[i][1],tripltes[i][2]));
        }
        System.out.println(trip.size());
        int max_i = 0 ;
        int max_j = 0 ;
        int max_k = 0 ;
        for(int i=0;i<trip.size();i++)
        {
        //     for(int j=i+1;j<trip.size();j++)
        // { 
        //     if(Math.max(trip.get(i).get(0),trip.get(j).get(0))==target[0]&&Math.max(trip.get(i).get(1),trip.get(j).get(1))==target[1]&&Math.max(trip.get(i).get(2),trip.get(j).get(2))==target[2])
        //     return true; 
        // }
        max_i = Math.max(max_i,trip.get(i).get(0));
        max_j = Math.max(max_j,trip.get(i).get(1));
        max_k = Math.max(max_k,trip.get(i).get(2));
        }
        // System.out.println(max_i+" "+max_j+" "+max_k);
        if(max_i==target[0]&&max_j==target[1]&&max_k==target[2])
        return true ;
        else return false ;
    }
}
