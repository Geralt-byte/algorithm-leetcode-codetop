package hot100.hash.a2;

import java.util.*;

/**
 * @author mlei@xjtu
 * @description 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * @create 2026/3/18 13:48
 */
public class Solution {
    //解法是为统计数组包装了一个类，并重新了equal和hashcode

    public static class CharNum{
        private int[] num;

        public CharNum(int[] num) {
            this.num = num;
        }

        public int[] getNum() {
            return num;
        }

        public void setNum(int[] num) {
            this.num = num;
        }

        @Override
        public boolean equals(Object object) {
            if (object == null || getClass() != object.getClass()) return false;
            CharNum charNum = (CharNum) object;
            return Objects.deepEquals(num, charNum.num);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(num);
        }
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result=new ArrayList<>();
        Map<CharNum,List<String>> map=new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            int[] temp = new int[26];
            for (int j = 0; j < str.length(); j++) {
                temp[str.charAt(j)-'a']+=1;
            }
            if(map.containsKey(new CharNum(temp))){
                List<String> list = map.get(new CharNum(temp));
                list.add(str);
            }
            else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(new CharNum(temp),list);
            }
        }
        result = map.values().stream().toList();
        return result;
    }
}
