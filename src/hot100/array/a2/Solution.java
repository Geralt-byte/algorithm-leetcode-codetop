package hot100.array.a2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author mlei@xjtu
 * @description 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 * @create 2026/3/20 16:50
 */
public class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = Arrays.stream(intervals).sorted((num1, num2) -> num1[0] - num2[0]).toList();
        List<int[]> map = new ArrayList<>();
        int i = 0;
        loop1:
        while (i < list.size()) {
            int start = list.get(i)[0];
            int end = list.get(i)[1];
            if (i == list.size() - 1){
                map.add(new int[]{start, end});
                break;
            }
            for (int j = i + 1; j < list.size(); j++) {
                i++;
                if (list.get(j)[0] <= end) {
                    end = Math.max(end, list.get(j)[1]);
                    if (i == list.size() - 1) {
                        map.add(new int[]{start, end});
                        break loop1;
                    }
                } else {
                    break;
                }
            }
            map.add(new int[]{start, end});
        }
        int[][] result = new int[map.size()][];
        for (int k = 0; k < map.size(); k++) {
            int[] num = new int[2];
            num[0] = map.get(k)[0];
            num[1] = map.get(k)[1];
            result[k] = num;
        }
        return result;
    }
}
