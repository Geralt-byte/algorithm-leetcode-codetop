package hot100.stack.a3;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author mlei@xjtu
 * @description 给定一个经过编码的字符串，返回它解码后的字符串。
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 * 测试用例保证输出的长度不会超过 105。
 * @create 2026/3/25 14:56
 */
public class Solution {
    public String decodeString(String s) {
        Deque<Character> dequeNum = new LinkedList<>();
        Deque<Character> dequeStr = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                dequeStr.push(ch);
            } else if (ch == '[') {
                dequeStr.push(ch);
                dequeNum.push(ch);
            } else {
                if (ch >= '0' && ch <= '9') {
                    dequeNum.push(ch);
                } else if (ch == ']') {
                    int count = 0;
                    int index=1;
                    dequeNum.pop();
                    while (!dequeNum.isEmpty()) {
                        if(dequeNum.peek()=='[') break;
                        count = count + (dequeNum.pop() - '0')*index;
                        index*=10;
                    }
                    StringBuilder sb = new StringBuilder();
                    while (dequeStr.peek() != '[') {
                        sb.insert(0, dequeStr.pop());
                    }
                    dequeStr.pop();
                    for (int j = 0; j < count; j++) {
                        for (int k = 0; k < sb.length(); k++) {
                            dequeStr.push(sb.charAt(k));
                        }
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!dequeStr.isEmpty()) {
            sb.append(dequeStr.removeLast());
        }
        return sb.toString();
    }
}
