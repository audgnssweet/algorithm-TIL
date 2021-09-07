package BestTimeToBuyAndSellStock2;

public class BestTimeToBuyAndSellStock2 {

    public int maxProfit(int[] prices) {
        int res = 0;

        int cur = 0;
        int hasStock = 0;
        boolean has = false;

        while (cur < prices.length - 1) {
            if (prices[cur] < prices[cur + 1] && !has) {
                has = true;
                hasStock = prices[cur];
            }

            if (prices[cur] > prices[cur + 1] && has) {
                has = false;
                res += (prices[cur] - hasStock);
                hasStock = 0;
            }

            cur += 1;
        }

        if (has) {
            res += (prices[prices.length - 1] - hasStock);
        }

        return res;
    }
}
