package hot100.back_tracking.a8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author mlei@xjtu
 * @description 按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * @create 2026/3/23 23:29
 */
public class Solution {

    private final List<List<String>> result = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] map = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = '.';
            }
        }
        back_tracking(map,0);
        return result;
    }

    private void back_tracking(char[][] map, int index) {
        if (index == map.length) {
            List<String> path=new ArrayList<>();
            for (int i = 0; i < map.length; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < map[i].length; j++) {
                    sb.append(map[i][j]);
                }
                path.add(sb.toString());
            }
            result.add(path);
            return;
        }
        for (int i = 0; i < map.length; i++) {
            if(judge(map,index,i)){
                map[index][i]='Q';
                back_tracking(map,index+1);
                map[index][i]='.';
            }
        }
    }

    private boolean judge(char[][] map, int row, int col) {
        for (int i = row - 1; i >= 0; i--) {
            if (map[i][col] == 'Q') return false;
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (map[i][j] == 'Q') return false;
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < map.length; i--, j++) {
            if (map[i][j] == 'Q') return false;
        }
        return true;
    }
}

