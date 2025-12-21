package org.interview.questions.array;

public class BuyAndSellStockII {

    public static int maxProfit(int[] prices){
        int maxProfit = 0;
        int n = prices.length;
        for(int i=1; i<n; i++){
            if(prices[i] > prices[i-1]){
                maxProfit = maxProfit+(prices[i]-prices[i-1]);
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
//        Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
//        Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
//        Total profit is 4 + 3 = 7.
        System.out.println("Max profit : "+maxProfit(new int[]{7,1,5,3,6,4}));
//        Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
//        Total profit is 4.
        System.out.println("Max profit : "+maxProfit(new int[]{1,2,3,4,5}));
//        Explanation: There is no way to make a positive profit, so we never buy the stock to achieve the maximum profit of 0.
        System.out.println("Max profit : "+maxProfit(new int[]{7,6,4,3,1}));
    }
}
