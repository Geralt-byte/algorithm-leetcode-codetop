package codetop.page02.a8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author mlei@xjtu
 * @description 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 * @create 2026/4/18 10:30
 */
public class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1) return intervals;
        Arrays.sort(intervals, (i, j) -> i[0] - j[0]);
        List<int[]> map = new ArrayList<>();
        map.add(new int[]{intervals[0][0], intervals[0][1]});
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > map.get(map.size() - 1)[1]) {
                map.add(new int[]{intervals[i][0], intervals[i][1]});
            } else {
                map.get(map.size() - 1)[1] = Math.max(intervals[i][1], map.get(map.size() - 1)[1]);
            }
        }
        return map.toArray(new int[map.size()][]);
    }
}
