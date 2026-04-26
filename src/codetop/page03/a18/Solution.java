package codetop.page03.a18;

/**
 * @author mlei@xjtu
 * @description 给你一个字符串 s ，请你反转字符串中 单词 的顺序。
 * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
 * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
 * @create 2026/4/26 14:09
 */
public class Solution {
    public String reverseWords(String s) {
        int n = s.length();
        if (n == 1) return s;
        int index = 0;
        StringBuilder sb = new StringBuilder();
        while (index < n && s.charAt(index) == ' ') index++;
        while (index < n) {
            StringBuilder stringBuilder = new StringBuilder();
            while (index < n && s.charAt(index) != ' ') {
                stringBuilder.append(s.charAt(index));
                index++;
            }
            sb.insert(0, stringBuilder);
            while (index < n && s.charAt(index) == ' ') index++;
            if (index < n) sb.insert(0, ' ');
        }
        return sb.toString();
    }
}
