package codetop.page01.a8;

import java.util.Arrays;

/**
 * @author mlei@xjtu
 * @description Main
 * @create 2026/4/13 14:35
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = solution.sortArray(new int[]{110, 100, 0});
        System.out.println(Arrays.toString(ints));
    }
}
