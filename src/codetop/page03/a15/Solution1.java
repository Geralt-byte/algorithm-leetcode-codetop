package codetop.page03.a15;

/**
 * @author mlei@xjtu
 * @description 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * @create 2026/4/25 14:35
 */
public class Solution1 {
    public int climbStairs(int n) {
        //时间复杂度超时
        if (n == 1 || n == 2) return n;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}
