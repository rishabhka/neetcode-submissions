class Solution {
    public int coinChange(int[] coins, int amount) {
        int [] minCoins = new int [amount +1] ;
        Arrays.fill(minCoins,Integer.MAX_VALUE-100000);
        Arrays.sort(coins);
        for(int i=0;i<coins.length;i++)
        {
            int coin = coins[i];
            for(int j=0;j<=amount;j++)
            {
                if(j%coin==0)
                minCoins[j] = j /coin ;
                else if(j>coin)
                {
                minCoins[j] = Math.min(minCoins[j],minCoins[j-coin]+1);
                }
            }
        }
        // for(int i=0;i<=amount;i++)
        // System.out.print(minCoins[i]+" ");
        return minCoins[amount]==Integer.MAX_VALUE-100000?-1:minCoins[amount];
    }
}
