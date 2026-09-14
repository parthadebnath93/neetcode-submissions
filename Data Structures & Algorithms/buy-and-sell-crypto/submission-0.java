class Solution {
    public int maxProfit(int[] prices) {
        int lowest=prices[0];
        int n=prices.length;
        int maxProfit=0;
        for(int i=1;i<n;i++){
            if(prices[i]<lowest){
                lowest=prices[i];
            }else{
                maxProfit=Integer.max(maxProfit,prices[i]-lowest);
            }
        }

        return maxProfit;
    }


}
