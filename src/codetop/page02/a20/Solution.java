package codetop.page02.a20;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author mlei@xjtu
 * @description 给你两个 版本号字符串 version1 和 version2 ，请你比较它们。版本号由被点 '.' 分开的修订号组成。修订号的值 是它 转换为整数 并忽略前导零。
 * 比较版本号时，请按 从左到右的顺序 依次比较它们的修订号。如果其中一个版本字符串的修订号较少，则将缺失的修订号视为 0。
 * 返回规则如下：
 * 如果 version1 < version2 返回 -1，
 * 如果 version1 > version2 返回 1，
 * 除此之外返回 0。
 * @create 2026/4/20 09:31
 */
public class Solution {
    public int compareVersion(String version1, String version2) {
        List<Integer> v1 = new ArrayList<>();
        List<Integer> v2 = new ArrayList<>();
        split(version1, v1);
        split(version2, v2);
        int index = 0;
        while (index < v1.size() && index < v2.size()) {
            if (v1.get(index) > v2.get(index)) return 1;
            else if (v1.get(index) < v2.get(index)) return -1;
            index++;
        }
        if (v1.size() == v2.size()) return 0;
        else {
            while (index < v1.size() && v1.get(index) == 0) index++;
            if (index < v1.size()) return 1;
            while (index < v2.size() && v2.get(index) == 0) index++;
            if (index < v2.size()) return -1;
            return 0;
        }
    }

    private void split(String version, List<Integer> v) {
        int num = 0;
        for (int i = 0; i < version.length(); i++) {
            if (version.charAt(i) == '.') {
                v.add(num);
                num = 0;
            } else {
                if (version.charAt(i) == '0' && num == 0) continue;
                int pos = version.charAt(i) - '0';
                num = num * 10 + pos;
                if (i == version.length() - 1) v.add(num);
            }
        }
    }
}
