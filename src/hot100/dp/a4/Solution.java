package hot100.dp.a4;

/**
 * @author mlei@xjtu
 * @description 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 * @create 2026/3/27 17:22
 */
public class Solution {
    public int numSquares(int n) {
        //状态转移方程    dp[i]=1+min(dp[i-j*j]),1<=j*j<=i
        //dp[i]代表数字i最少可以由多少个完全平方数组成
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int count=Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                count= Math.min(count,dp[i-j*j]);
            }
            dp[i]=1+count;
        }
        return dp[n];
    }
}
