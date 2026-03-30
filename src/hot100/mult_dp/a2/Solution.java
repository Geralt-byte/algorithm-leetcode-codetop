package hot100.mult_dp.a2;

/**
 * @author mlei@xjtu
 * @description 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 * @create 2026/3/28 23:44
 */
public class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int pathLeft = 0, pathTop = 0, pathMin = 0;
                if (i > 0) {
                    pathTop = dp[i - 1][j];
                }
                if (j > 0) {
                    pathLeft = dp[i][j - 1];
                }
                if (i == 0) pathMin = pathLeft;
                if (j == 0) pathMin = pathTop;
                if (i != 0 && j != 0) pathMin = Math.min(pathLeft, pathTop);
                dp[i][j] = grid[i][j] + pathMin;
            }
        }
        return dp[m - 1][n - 1];
    }
}
