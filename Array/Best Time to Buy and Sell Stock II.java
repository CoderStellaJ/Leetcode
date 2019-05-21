/*
Runtime: 1 ms, faster than 80.71% of Java online submissions for Best Time to Buy and Sell Stock II.
Memory Usage: 36.7 MB, less than 63.90% of Java online submissions for Best Time to Buy and Sell Stock II.

Complexity:
runtime: O(N)
space: O(1)

Algorithm 2:
improve space complexity from Algorithm 1. Use buy and sell to record index suitable for buying and selling.
*/
///////////////////////////////////////////////////////////////////////////////////////////////////////////
class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        if(prices.length <= 1) return 0;
        int buy = -1, sell = -1;
        for(int i = 0; i < prices.length; i++) {
          if(i == 0) {
            if(prices[i] < prices[i+1]) buy = i;
          }else if(i == prices.length -1){
            if(prices[i] > prices[i-1]) {
              sell = i;
              if(buy != -1) {
                profit += prices[sell] - prices[buy];
                sell = -1;
                buy = -1;
              }
            }
          }else{
            if(prices[i] > prices[i-1] && prices[i] >= prices[i+1]){
              sell = i;
              if(buy != -1) {
                profit += prices[sell] - prices[buy];
                sell = -1;
                buy = -1; 
              }
            }else if(prices[i] < prices[i+1] && prices[i] <= prices[i-1]) buy = i;
          }
        }
        return profit;
    }
}

//////////////////////////////////////////////////////////////////////////////////////////////////////////
/*
Runtime: 1 ms, faster than 80.71% of Java online submissions for Best Time to Buy and Sell Stock II.
Memory Usage: 36.1 MB, less than 67.11% of Java online submissions for Best Time to Buy and Sell Stock II.

Complexity:
runtime: O(N)
space: O(N)

Algorithm 1:
use an array to record whether day i is suitable for buying or selling
buy: prices[i] is the valley
sell: prices[i] is the top
Note:
consider the case when prices[i] can equal to its neighbor
*/
/////////////////////////////////////////////////////////////////////////////////////////////////////
class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        if(prices.length <= 1) return 0;    //consider the case when length is too short
        int[] market = new int[prices.length];
        // 1: sell, -1:buy, 0: nothing
        for(int i = 0; i < prices.length; i++) {
          if(i == 0 ){
            if(prices[i] <= prices[i+1]) market[i] = -1;    //with equal sign !
          } 
          else if(i == prices.length-1){
            if(prices[i] >= prices[i-1]) market[i] = 1;     //with equal sign !
          } 
          else{
            if(prices[i] > prices[i-1] && prices[i] >= prices[i+1]) market[i] = 1;    
            //for selling, larger than previous price and can be equal to the next price, closest sell 
            else if(prices[i] <= prices[i-1] && prices[i] < prices[i+1]) market[i] = -1;
            //for buying, smaller than the next value, closest buy
          }
        }
        int buy = -1, sell = -1;
        for(int i = 0; i < prices.length; i++) {
          if(market[i] == 1) {
            sell = i;
            if(buy != -1) profit += prices[sell] - prices[buy];
            buy = -1;
            sell = -1;
          }
          else if(market[i] == -1) buy = i;
        }
        return profit;
    }
}
