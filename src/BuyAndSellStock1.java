public class BuyAndSellStock1 {
    public int maxProfit(int[] prices) {

        int buy = prices[0], sell = 0;

        for (int price : prices) {
            sell = Math.max(price - buy, sell);
            buy = Math.min(price, buy);
        }

        return sell;
    }
}
