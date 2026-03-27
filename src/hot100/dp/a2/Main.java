package hot100.dp.a2;

import java.util.List;

/**
 * @author mlei@xjtu
 * @description Main
 * @create 2026/3/27 17:51
 */
public class Main {
    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        List<List<Integer>> generate = solution.generate(5);
        System.out.println(generate);
    }
}
