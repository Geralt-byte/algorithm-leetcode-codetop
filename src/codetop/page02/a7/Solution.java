package codetop.page02.a7;

/**
 * @author mlei@xjtu
 * @description 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。
 * 你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。
 * @create 2026/4/18 10:17
 */
public class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int i = num1.length() - 1, j = num2.length() - 1;
        int num = 0;
        while (i >= 0 || j >= 0) {
            int k = num;
            if (i >= 0) {
                k += num1.charAt(i) - '0';
            }
            if (j >= 0) {
                k += num2.charAt(j) - '0';
            }
            sb.insert(0, k % 10);
            num = k / 10;
            i--;
            j--;
        }
        if (num > 0) sb.insert(0, num);
        return sb.toString();
    }
}
