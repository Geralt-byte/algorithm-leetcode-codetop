package codetop.page05.a2;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author mlei@xjtu
 * @description 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 * @create 2026/5/5 09:32
 */
public class Solution {
    public String largestNumber(int[] nums) {
        String[] strings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strings[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strings, (a, b) -> (b + a).compareTo(a + b));
        if (strings[0].equals("0")) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (String string : strings) {
            sb.append(string);
        }
        return sb.toString();
    }
}
