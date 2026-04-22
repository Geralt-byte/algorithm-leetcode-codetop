package codetop.page03.a5;

/**
 * @author mlei@xjtu
 * @description 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 * @create 2026/4/21 09:57
 */
public class Solution1 {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        double x0 = x, C = x;
        while (true) {
            double xi = 0.5 * (x0 + C / x0);
            if (Math.abs(xi - x0) <= 1e-7) {
                break;
            }
            x0 = xi;
        }
        return (int) x0;
    }
}