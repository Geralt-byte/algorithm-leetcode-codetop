package codetop.page02.a13;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mlei@xjtu
 * @description 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。
 * 你 不能 重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
 * @create 2026/4/19 08:42
 */
public class Solution {

    private final List<String> result = new ArrayList<>();
    private final List<String> path = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        back_tracking(s, 0, new StringBuilder());
        return result;
    }

    private void back_tracking(String s, int start, StringBuilder sb) {
        if (path.size() == 4 && start == s.length()) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < 4; i++) {
                stringBuilder.append(path.get(i));
                if (i < 3) stringBuilder.append(".");
            }
            result.add(stringBuilder.toString());
            return;
        }
        for (int i = start; i < s.length(); i++) {
            sb.append(s.charAt(i));
            if (judge(sb.toString()) && path.size() < 4) {
                path.add(sb.toString());
                back_tracking(s, i + 1, new StringBuilder());
                path.remove(path.size() - 1);
            } else break;
        }
    }

    private boolean judge(String str) {
        if (str.length() > 3) return false;
        if (str.length() > 1 && str.charAt(0) == '0') return false;
        return Integer.parseInt(str) < 256;
    }
}
