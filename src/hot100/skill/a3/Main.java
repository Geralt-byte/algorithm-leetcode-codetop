package hot100.skill.a3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author mlei@xjtu
 * @description Main
 * @create 2026/3/26 23:16
 */
public class Main {
    public static void main(String[] args) {
        //生成测试用例
        Random random = new Random();
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            int n = random.nextInt(6);
            list.add(n);
        }
        System.out.println(list);
        int[] array = list.stream().mapToInt(Integer::intValue).toArray();

        Solution solution = new Solution();
        solution.sortColors(array);
        System.out.println(Arrays.toString(array));
    }
}
