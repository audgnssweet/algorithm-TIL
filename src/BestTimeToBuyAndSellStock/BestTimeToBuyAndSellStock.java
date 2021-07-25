package BestTimeToBuyAndSellStock;

public class BestTimeToBuyAndSellStock {

    public static int maxProfit(int[] prices) {
        int min = 0, max = 1, maxGap = 0, gap = 0;
        while (max < prices.length) {
            gap = prices[max] - prices[min];
            if (gap < 1) {
                min = max;
            } else {
                maxGap = Math.max(maxGap, gap);
            }
            ++max;
        }
        return maxGap;
    }

}
