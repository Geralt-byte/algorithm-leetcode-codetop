package hot100.sliding_window.a2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author mlei@xjtu
 * @description 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * @create 2026/3/19 13:41
 */
public class Solution1 {
    public List<Integer> findAnagrams(String s, String p) {
        //优化的滑动窗口
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) return result;
        int start = 0, end = p.length() - 1;
        //数组维护滑动窗口和子串字母的数量差值，differ维护不同的数量
        int[] count = new int[26];
        int differ = 0;
        for (int i = 0; i < p.length(); i++) {
            count[p.charAt(i) - 'a'] -= 1;
            count[s.charAt(i) - 'a'] += 1;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) differ++;
        }
        while (end < s.length()) {
            if (differ == 0) {
                result.add(start);
            }
            //扣减前为1说明有一个位置的数量变为相同,differ--，为0说明有一个位置的数量变为不同,differ++，
            if (count[s.charAt(start) - 'a'] == 1) {
                differ--;
            } else if (count[s.charAt(start) - 'a'] == 0) {
                differ++;
            }
            count[s.charAt(start) - 'a'] -= 1;
            if (end < s.length() - 1) {
                //同理
                if (count[s.charAt(end + 1) - 'a'] == -1) {
                    differ--;
                } else if (count[s.charAt(end + 1) - 'a'] == 0) {
                    differ++;
                }
                count[s.charAt(end + 1) - 'a'] += 1;
            }
            start++;
            end++;
        }
        return result;
    }
}
