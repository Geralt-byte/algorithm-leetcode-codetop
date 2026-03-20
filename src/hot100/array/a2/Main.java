package hot100.array.a2;

import java.util.Arrays;

/**
 * @author mlei@xjtu
 * @description Main
 * @create 2026/3/20 22:22
 */
public class Main {
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int[][] merge = solution1.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
        System.out.println(Arrays.deepToString(merge));
    }
}

