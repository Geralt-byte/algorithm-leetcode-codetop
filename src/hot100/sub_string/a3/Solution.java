package hot100.sub_string.a3;

/**
 * @author mlei@xjtu
 * @description 给定两个字符串 s 和 t，长度分别是 m 和 n，返回 s 中的 最短窗口 子串，使得该子串包含 t 中的每一个字符（包括重复字符）。
 * 如果没有这样的子串，返回空字符串 ""。
 * 测试用例保证答案唯一。
 * @create 2026/3/19 16:49
 */
public class Solution {
    public String minWindow(String s, String t) {
        String result = "";
        if (s.length() < t.length()) return result;
        int start = 0, end = 0;
        int[] map = new int[52];
        int[] window = new int[52];
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (ch <= 'z' && ch >= 'a') {
                map[ch - 'a']++;
            } else {
                map[ch - 'A' + 26]++;
            }
        }
        for (; end < s.length(); end++) {
            char ch = s.charAt(end);
            if (ch <= 'z' && ch >= 'a') {
                window[ch - 'a']++;
            } else {
                window[ch - 'A' + 26]++;
            }
            if (check(window, map)) {
                result = s.substring(start, end + 1);
                break;
            }
        }
        if (result.isEmpty()) return result;
        while (end < s.length()) {
            while (check(window, map)) {
                if (result.length() > end - start + 1) {
                    result = s.substring(start, end + 1);
                }
                char ch = s.charAt(start);
                if (ch <= 'z' && ch >= 'a') {
                    window[ch - 'a']--;
                } else {
                    window[ch - 'A' + 26]--;
                }
                start++;
            }
            end++;
            if (end < s.length()) {
                char ch = s.charAt(end);
                if (ch <= 'z' && ch >= 'a') {
                    window[ch - 'a']++;
                } else {
                    window[ch - 'A' + 26]++;
                }
            }
        }
        return result;
    }

    private boolean check(int[] window, int[] map) {
        for (int i = 0; i < map.length; i++) {
            if (window[i] < map[i]) {
                return false;
            }
        }
        return true;
    }
}
