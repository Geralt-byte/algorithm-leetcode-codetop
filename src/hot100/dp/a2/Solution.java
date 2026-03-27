package hot100.dp.a2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mlei@xjtu
 * @description 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 * @create 2026/3/27 17:22
 */
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        //二次项系数
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                list.add(quadraticCoefficient(i, j));
            }
            result.add(list);
        }
        return result;
    }

    public int quadraticCoefficient(int n, int i) {
        if (i > n / 2) i = n - i;
        if (i == 0) return 1;
        if (i == 1) return n;
        long top = 1;
        for (int count = 0; count < i; count++) {
            top *= (n - count);
        }
        return (int) (top / factorial(i));
    }

    public long factorial(int n) {
        if (n == 0 || n == 1) return 1;
        long sum = 1;
        for (int i = 2; i <= n; i++) {
            sum *= i;
        }
        return sum;
    }
}
