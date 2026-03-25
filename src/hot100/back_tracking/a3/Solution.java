package hot100.back_tracking.a3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mlei@xjtu
 * @description 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * @create 2026/3/23 23:29
 */
public class Solution {

    private final List<String> result=new ArrayList<>();
    private final StringBuilder sb=new StringBuilder();

    public List<String> letterCombinations(String digits) {
        back_tracking(digits,0);
        return result;
    }

    private void back_tracking(String digits,int index){
        if(sb.length()==digits.length()){
            result.add(sb.toString());
            return;
        }
        char ch=digits.charAt(index);
        int length=3;
        if(ch=='7'||ch=='9') length=4;
        for (int i = 0; i < length; i++) {
            char temp;
            if (ch>'7') {
                temp = (char)((ch - '2') * 3+i+1+'a');
            }else {
                temp = (char)((ch - '2') * 3+i+'a');
            }
            sb.append(temp);
            back_tracking(digits,index+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
