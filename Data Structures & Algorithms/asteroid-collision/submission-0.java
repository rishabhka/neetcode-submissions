class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<asteroids.length;i++)
        {
            if(asteroids[i]>=0)
            result.add(asteroids[i]);
            if(asteroids[i]<0)
            {
                if(result.size()>0&&result.get(result.size()-1)>0)
                {
                        while(result.size()>0&&result.get(result.size()-1)>0&&result.get(result.size()-1)<Math.abs(asteroids[i]))
                        {
                            result.remove(result.size()-1);
                        }
                         if(result.size()>0&&result.get(result.size()-1)>Math.abs(asteroids[i]))
                        {
                            continue ;
                            
                        }
                        else if(result.size()>0&&result.get(result.size()-1)==Math.abs(asteroids[i]))
                        {
                            result.remove(result.size()-1);
                            continue ;
                            
                        }
                        result.add(asteroids[i]);
                        
                }
                else
                result.add(asteroids[i]);
                
            }
        }
        int [] res = new int[result.size()];
        for(int i=0;i<result.size();i++)
        res[i] = result.get(i);
        return res ;
    }
}