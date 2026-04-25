package codetop.page03.a14;

/**
 * @author mlei@xjtu
 * @description 给定两个字符串 s 和 t，长度分别是 m 和 n，返回 s 中的 最短窗口 子串，
 * 使得该子串包含 t 中的每一个字符（包括重复字符）。如果没有这样的子串，返回空字符串 ""。
 * 测试用例保证答案唯一。
 * @create 2026/4/25 13:21
 */
public class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        int[] map = new int[128];
        int[] window = new int[128];
        int start = 0, end = 0, index = 0, need = 0, valid = 0, minLen = Integer.MAX_VALUE;
        for (int i = 0; i < t.length(); i++) {
            if (map[t.charAt(i)] == 0) need++;
            map[t.charAt(i)]++;
        }
        while (end < s.length()) {
            int endS = s.charAt(end);
            end++;
            if (map[endS] > 0) {
                window[endS]++;
                if (window[endS] == map[endS]) valid++;
            }
            while (valid == need) {
                if (end - start < minLen) {
                    minLen = end - start;
                    index = start;
                }
                int startS = s.charAt(start);
                start++;
                if (map[startS] > 0) {
                    if (window[startS] == map[startS]) {
                        valid--;
                    }
                    window[startS]--;
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(index, index + minLen);
    }
}
