package hot100.dp.a2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mlei@xjtu
 * @description 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 * @create 2026/3/27 17:22
 */
public class Solution1 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            List<Integer> list = new ArrayList<>();
            if (i == 1) list.add(1);
            else if (i == 2) {
                list.add(1);
                list.add(1);
            } else {
                for (int j = 0; j < i; j++) {
                    if (j == 0 || j == i - 1) list.add(1);
                    else list.add(result.get(i - 2).get(j - 1) + result.get(i - 2).get(j));
                }
            }
            result.add(list);
        }
        return result;
    }
}
