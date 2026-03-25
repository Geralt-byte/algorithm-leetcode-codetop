package hot100.stack.a4;

import java.util.Arrays;

/**
 * @author mlei@xjtu
 * @description Main
 * @create 2026/3/25 19:49
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints1 = {89,62,70,58,47,47,46,76,100,70};
        int[] ints = solution.dailyTemperatures(ints1);
        System.out.println(Arrays.toString(ints));
    }
}
