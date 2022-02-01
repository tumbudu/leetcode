// 121. Best Time to Buy and Sell Stock
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

class Solution {
    public int maxProfit(int[] prices) {
     
        int arrLen = prices.length;
        int buy = prices[0];
        int profit = 0;
        
        for(int i = 0; i<arrLen; i++){
            if(prices[i] <= buy){
                buy = prices[i];
            }else{
                if(prices[i] - buy > profit){
                    profit = prices[i] - buy;
                }
            }
        }
        return profit;
        
    }
}
