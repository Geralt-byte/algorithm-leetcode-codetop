package codetop.page03.a11;

/**
 * @author mlei@xjtu
 * @description 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * 你可以认为每种硬币的数量是无限的。
 * @create 2026/4/25 11:11
 */
public class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            int count = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] < i && dp[i - coins[j]] != 0) {
                    count = Math.min(count, dp[i - coins[j]]);
                } else if (coins[j] == i) {
                    count = Math.min(count, 0);
                }
            }
            dp[i] = count == Integer.MAX_VALUE ? 0 : 1 + count;
        }
        return dp[amount]==0?-1:dp[amount];
    }
}
