package hot100.map.a1;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author mlei@xjtu
 * @description 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围。
 * @create 2026/3/23 14:54
 */
public class Solution1 {
    //bfs
    private final int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};

    public int numIslands(char[][] grid) {
        int[][] visited=new int[grid.length][grid[0].length];
        int result=0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j]=='1'&&visited[i][j]==0){
                    result++;
                    bfs(grid,visited,i,j);
                }
            }
        }
        return result;
    }

    private void bfs(char[][] grid, int[][] visited, int row, int col){
        Deque<int[]> deque=new LinkedList<>();
        deque.offer(new int[]{row,col});
        visited[row][col]=1;
        while (!deque.isEmpty()){
            int[] poll = deque.poll();
            for (int i = 0; i < dir.length; i++) {
                int nextRow=poll[0]+dir[i][0];
                int nextCol=poll[1]+dir[i][1];
                if(nextRow<0||nextRow>visited.length-1||nextCol<0||nextCol>visited[nextRow].length-1) continue;
                if(visited[nextRow][nextCol]==0&&grid[nextRow][nextCol]=='1'){
                    deque.offer(new int[]{nextRow,nextCol});
                    visited[nextRow][nextCol]=1;
                }
            }
        }

    }
}
