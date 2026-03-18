package hot100.hash.a2;

import java.util.*;

/**
 * @author mlei@xjtu
 * @description 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * @create 2026/3/18 13:48
 */
public class Solution2 {
    //使用a1b2c1....这种字符串用来统计字数，一样可以用来做key
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            int[] temp=new int[26];
            for (int j = 0; j < strs[i].length(); j++) {
                temp[strs[i].charAt(j)-'a']+=1;
            }
            StringBuilder sb = new StringBuilder();
            for (int k = 0; k < temp.length; k++) {
                if(temp[k]!=0){
                    sb.append((char)(k+'a'));
                    sb.append(temp[k]);
                }
            }
            String string = sb.toString();
            List<String> list = map.getOrDefault(string, new ArrayList<String>());
            list.add(strs[i]);
            map.put(string,list);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
