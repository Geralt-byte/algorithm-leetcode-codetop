package hot100.dp.a1;

/**
 * @author mlei@xjtu
 * @description 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * @create 2026/3/27 16:53
 */
public class Solution {
    public int climbStairs(int n) {
        if(n==1||n==2) return n;
        int[] dp=new int[n];
        dp[0]=1;
        dp[1]=2;
        for (int i = 2; i < n; i++) {
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n-1];
    }
}
