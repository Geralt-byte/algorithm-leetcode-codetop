package hot100.hash.a2;

import java.util.*;

/**
 * @author mlei@xjtu
 * @description 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * @create 2026/3/18 13:48
 */
public class Solution1 {
    //原串排序后为字母异位词的一定相等，可以用来做key
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] charArray = strs[i].toCharArray();
            Arrays.sort(charArray);
            String string = Arrays.toString(charArray);
            List<String> list = map.getOrDefault(string, new ArrayList<String>());
            list.add(strs[i]);
            map.put(string,list);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
