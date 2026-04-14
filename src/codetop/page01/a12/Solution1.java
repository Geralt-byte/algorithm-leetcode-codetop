package codetop.page01.a12;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author mlei@xjtu
 * @description 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围。
 * @create 2026/4/14 14:01
 */
public class Solution1 {
    //bfs
    private final int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int result = 0;
        int[][] flag = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (flag[i][j] == 0 && grid[i][j] == '1') {
                    bfs(grid, flag, i, j);
                    result++;
                }
            }
        }
        return result;
    }

    private void bfs(char[][] grid, int[][] flag, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        Deque<int[]> deque = new LinkedList<>();
        deque.offer(new int[]{i, j});
        flag[i][j]=1;
        while (!deque.isEmpty()) {
            int[] poll = deque.poll();
            for (int k = 0; k < 4; k++) {
                int newRow = poll[0] + dir[k][0];
                int newCol = poll[1] + dir[k][1];
                if (newRow < 0 || newCol < 0 || newRow >= m || newCol >= n) {
                    continue;
                }
                if (grid[newRow][newCol] == '1' && flag[newRow][newCol] == 0) {
                    deque.offer(new int[]{newRow, newCol});
                    //注意flag数组的修改时机要是入队后立即修改
                    flag[newRow][newCol]=1;
                }
            }
        }
    }
}
