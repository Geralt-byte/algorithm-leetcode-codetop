package codetop.page04.a10;

/**
 * @author mlei@xjtu
 * @description 给你一个大小为 m x n 的二进制矩阵 grid 。
 * 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，
 * 这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。
 * 你可以假设 grid 的四个边缘都被 0（代表水）包围着。
 * 岛屿的面积是岛上值为 1 的单元格的数目。
 * 计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。
 * @create 2026/4/29 10:33
 */
public class Solution {

    private final int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private boolean[][] flag;
    private int sum;

    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        flag = new boolean[m][n];
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !flag[i][j]) {
                    sum = 0;
                    dfs(grid, i, j);
                    result = Math.max(result, sum);
                }
            }
        }
        return result;
    }

    private void dfs(int[][] grid, int row, int col) {
        if (grid[row][col] == 1 && !flag[row][col]) {
            sum++;
            flag[row][col] = true;
            for (int i = 0; i < 4; i++) {
                int newRow = row + dir[i][0];
                int newCol = col + dir[i][1];
                if (newRow < 0 || newRow >= grid.length || newCol < 0 || newCol >= grid[0].length) {
                    continue;
                }
                dfs(grid, newRow, newCol);
            }
        }
    }
}
