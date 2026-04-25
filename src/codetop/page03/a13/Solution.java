package codetop.page03.a13;

/**
 * @author mlei@xjtu
 * @description 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * 注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。
 * @create 2026/4/25 12:45
 */
public class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = num2.length() - 1; i >= 0; i--) {
            int index = -1;
            if (!sb.isEmpty()) {
                index = sb.length() - 1 - count;
            }
            int a = num2.charAt(i) - '0';
            int temp = 0;
            for (int j = num1.length() - 1; j >= 0; j--) {
                int b = num1.charAt(j) - '0';
                temp = temp + a * b;
                if (index == -1) {
                    sb.insert(0, temp % 10);
                } else {
                    int c = sb.charAt(index) - '0';
                    temp = temp + c;
                    sb.setCharAt(index, (char) (temp % 10 + 48));
                    index--;
                }
                temp /= 10;
            }
            if (temp > 0) sb.insert(0, temp);
            count++;
        }
        return sb.toString();
    }
}
