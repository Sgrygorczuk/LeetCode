package com.leet_code.game.problems;

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 *
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 *
 *
 *
 * Example 1:
 *
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 * Example 2:
 *
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transactions are done and the max profit = 0.
 *
 *
 * Constraints:
 *
 * 1 <= prices.length <= 105
 * 0 <= prices[i] <= 104
 */
public class P121 {
    class Solution {
        public int maxProfit(int[] prices) {
            //BEST Anwser
                int minprice = Integer.MAX_VALUE;
                int maxprofit = 0;
                for (int i = 0; i < prices.length; i++) {
                    //We find the current minimum price
                    if (prices[i] < minprice)
                        minprice = prices[i];
                    //If we're not chaning our current minimum price we check if this is the max
                    //profit we could get
                    //If it is we save the profit as we look for another low
                    else if (prices[i] - minprice > maxprofit)
                        maxprofit = prices[i] - minprice;
                }
                return maxprofit;
            }
        }

        /**
         * Works but takes too long to solve really big arrays, good answer
         * @param prices
         */
        private int attemptTwo(int[] prices){
            int profit = 0;

            for(int i = 0; i < prices.length; i++){
                for(int j = i + 1; j < prices.length; j++){
                    if(prices[j] - prices[i] > profit){
                        profit = prices[j] - prices[i];
                    }
                }
            }

            return profit;
        }


        /**
         * First attempt didn't really account for dealing with not lowest and highest
         * @param prices
         */
        private int attemptOne(int[] prices){
            int low = 110;
            int lowIndex = 0;
            int high;
            //Find the lowest
            //Get it's position and find the highest after the lowest, if any exist
            //Find the difference
            for(int i = 0; i < prices.length; i++){
                if(prices[i] < low){
                    low = prices[i];
                    lowIndex = i;
                }
            }

            //In case the lowest is the last one look for next lowest
            if(lowIndex == prices.length-1){
                low = 110;
                for(int i = 0; i < prices.length - 1; i++){
                    if(prices[i] < low){
                        low = prices[i];
                        lowIndex = i;
                    }
                }
            }

            high = low;

            //Find the highest after the lowest
            for(int i = lowIndex; i < prices.length; i++){
                if(prices[i] > high){
                    high = prices[i];
                }
            }

            return high - low;
        }
}

