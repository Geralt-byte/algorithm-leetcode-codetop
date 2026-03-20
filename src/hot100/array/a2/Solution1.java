package hot100.array.a2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author mlei@xjtu
 * @description 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 * @create 2026/3/20 16:50
 */
public class Solution1 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1) return new int[][]{{intervals[0][0], intervals[0][1]}};
        Arrays.sort(intervals, (num1, num2) -> num1[0] - num2[0]);
        List<int[]> map = new ArrayList<>();
        map.add(new int[]{intervals[0][0], intervals[0][1]});
        for (int i = 1; i < intervals.length; i++) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            int index = map.size() - 1;
            if (left > map.get(index)[1]) {
                map.add(new int[]{left, right});
            } else {
                map.get(index)[1] = Math.max(map.get(index)[1], right);
            }
        }
        return map.toArray(new int[map.size()][]);
    }
}
