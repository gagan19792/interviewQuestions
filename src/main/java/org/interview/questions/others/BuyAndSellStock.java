package org.interview.questions.others;

//You are given an array prices where prices[i] is the price of a given stock on the ith day.
//
//You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
//
//Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
//
//Example 1:
//
//Input: prices = [7,1,5,3,6,4]
//Output: 5
//Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
//Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
//Example 2:
//
//Input: prices = [7,6,4,3,1]
//Output: 0
//Explanation: In this case, no transactions are done and the max profit = 0.
//Constraints:
//
//        0 <= prices[i] <= 104
//        1 <= prices.length <= 105
public class BuyAndSellStock {

    public static void main(String[] args) {
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        int[] prices2 = {7, 6, 4, 3, 1};

        System.out.println(maxProfit(prices1)); // 5
        System.out.println(maxProfit(prices2)); // 0
    }
    public static int maxProfit(int prices[]){
//        Explanation:
//        Initialize Variables:
//
//        minPrice is set to the maximum possible integer value (Integer.MAX_VALUE). This variable tracks the lowest price encountered so far.
//
//        maxProfit is initialized to 0. This variable tracks the maximum profit that can be achieved.
//
//        Iterate Through Prices:
//
//        For each day's price, we check if it is less than the current minPrice. If it is, we update minPrice to this price.
//
//        Otherwise, we calculate the potential profit if we were to sell at this day's price (prices[i] - minPrice). If this profit is greater than maxProfit, we update maxProfit.
//
//        Return Result:
//
//        The function returns maxProfit, which is the maximum profit that can be achieved by buying and selling on different days.

//                Time Complexity:
//        The time complexity is O(n), where n is the length of the prices array. This is because we iterate through the array only once.

//        Space Complexity:
//        The space complexity is O(1) because we are using a constant amount of extra space for the variables minPrice and maxProfit.

        if(prices == null || prices.length ==0){
            return 0;
        }
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int i=0; i<prices.length;i++){
            if(prices[i] < minPrice){
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;

            }
        }
        return maxProfit;


    }
}
