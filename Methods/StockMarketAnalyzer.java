// This class calculates the maximum possible profit from a 7-day stock price history 
// by identifying the optimal time to buy and sell.

package Methods;

import java.util.Scanner;

public class StockMarketAnalyzer {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        double[] prices = new double[7];

        for (int i = 1; i <= 7 ; i++) {
            System.out.print("Day " + i + " price: ");
            prices[i - 1] = input.nextDouble();
        }

        double maxProfit = getMaxProfit(prices);
        String resultText =  "Max profit: " + maxProfit;
        if(maxProfit == 0.0){
            resultText =  resultText + " (No profitable opportunity)";
        }

        System.out.println("\n" + resultText);
    }

    public static double getMaxProfit(double[] prices){
        double minPrice = prices[0];
        double maxProfit = 0.0;

        for (int j = 0; j < prices.length; j++) {
            minPrice = Math.min(minPrice, prices[j]);
            maxProfit = Math.max(maxProfit, (prices[j] - minPrice));
        }

        return maxProfit;
    }
}
