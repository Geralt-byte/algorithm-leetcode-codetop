package codetop.page04.a12;

/**
 * @author mlei@xjtu
 * @description 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
 * @create 2026/4/30 10:29
 */
public class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int maxLength = 0;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0') {
                    dp[i][j] = 0;
                } else {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        int pre = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j]));
                        dp[i][j] = 1 + pre;
                    }
                }
                maxLength = Math.max(maxLength, dp[i][j]);
            }
        }
        return (int) Math.pow(maxLength, 2);
    }
}
