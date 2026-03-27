package hot100.greedy.a1;

/**
 * @author mlei@xjtu
 * @description 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 * @create 2026/3/26 15:55
 */
public class Solution1 {
    public int maxProfit(int[] prices) {
        //greedy
        if (prices.length < 2) return 0;
        int max = 0;
        int minPrices = Integer.MAX_VALUE;
        for (int price : prices) {
            minPrices = Math.min(minPrices, price);
            max = Math.max(max, price - minPrices);
        }
        return max;
    }
}
