package org.interview.questions.array;

public class BuyAndSellStock {

    public static  int bruteForce(int prices[]){
        int maxProfit = 0;
        for(int buyDay = 0; buyDay < prices.length; buyDay++){
            for(int sellDay = buyDay+1; sellDay < prices.length; sellDay++){
                int currentDifference = prices[sellDay]-prices[buyDay];
                if(currentDifference > maxProfit){
                    maxProfit = currentDifference;
                }
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = new int[] {7,1,5,3,6,4};
        System.out.println(bruteForce(prices));
    }
}
