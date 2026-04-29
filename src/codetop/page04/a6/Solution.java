package codetop.page04.a6;

/**
 * @author mlei@xjtu
 * @description 给定一个包含非负整数的 m x n 网格 grid ，
 * 请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 * @create 2026/4/29 09:04
 */
public class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int left = 0, top = 0, pre = Integer.MAX_VALUE;
                if (i > 0) {
                    top = dp[i - 1][j];
                    pre = top;
                }
                if (j > 0) {
                    left = dp[i][j - 1];
                    pre = Math.min(pre, left);
                }
                dp[i][j] = (pre == Integer.MAX_VALUE ? 0 : pre) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }
}
