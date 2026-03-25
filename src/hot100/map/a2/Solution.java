package hot100.map.a2;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author mlei@xjtu
 * @description 在给定的 m x n 网格 grid 中，每个单元格可以有以下三个值之一：
 * 值 0 代表空单元格；
 * 值 1 代表新鲜橘子；
 * 值 2 代表腐烂的橘子。
 * 每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。
 * 返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1 。
 * @create 2026/3/23 16:43
 */
public class Solution {
    //bfs

    //方向数组
    private final int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] visited = new int[m][n];
        //新鲜橘子数量
        int fresh = 0;
        //存储烂橘子坐标
        List<int[]> rots = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                } else if (grid[i][j] == 2) {
                    rots.add(new int[]{i, j});
                }
            }
        }
        //初始状态没有新鲜橘子，直接返回0
        if (fresh == 0) return 0;
        int[] bfs = bfs(grid, visited, rots, fresh);
        //bfs后没有新鲜橘子，返回时间，有则返回-1
        return bfs[1] == 0 ? bfs[0] : -1;
    }

    //多源广度优先遍历
    private int[] bfs(int[][] grid, int[][] visited, List<int[]> rots, int fresh) {
        //时间计数
        int time = -1;
        Deque<int[]> deque = new LinkedList<>();
        for (int[] rot : rots) {
            deque.offer(new int[]{rot[0], rot[1]});
            visited[rot[0]][rot[1]] = 1;
        }
        while (!deque.isEmpty()) {
            time++;
            //每次取节点前要获得当前队列内的节点数量
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                //烂橘子出队
                int[] poll = deque.poll();
                //向四个方向扩展
                for (int j = 0; j < dir.length; j++) {
                    int nextRaw = dir[j][0] + poll[0];
                    int nextCol = dir[j][1] + poll[1];
                    //边界跳过
                    if (nextRaw < 0 || nextRaw > visited.length - 1 || nextCol < 0 || nextCol > visited[nextRaw].length - 1)
                        continue;
                    //已访问和空节点跳过
                    if (visited[nextRaw][nextCol] == 0 && grid[nextRaw][nextCol] == 1) {
                        //新鲜橘子腐烂
                        fresh--;
                        //烂橘子入队
                        deque.offer(new int[]{nextRaw, nextCol});
                        //已访问标记
                        visited[nextRaw][nextCol] = 1;
                    }
                }
            }
        }
        //返回时间和新鲜橘子数量
        return new int[]{time, fresh};
    }
}
