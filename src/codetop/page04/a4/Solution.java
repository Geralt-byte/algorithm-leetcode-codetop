package codetop.page04.a4;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author mlei@xjtu
 * @description 给定一个经过编码的字符串，返回它解码后的字符串。
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 * 测试用例保证输出的长度不会超过 105。
 * @create 2026/4/27 08:55
 */
public class Solution {
    public String decodeString(String s) {
        Deque<Integer> numStack = new LinkedList<>();
        Deque<Character> charStack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) <= '9' && s.charAt(i) >= '0') {
                if (i > 0 && s.charAt(i - 1) <= '9' && s.charAt(i - 1) >= '0') {
                    Integer pop = numStack.pop();
                    pop = pop * 10 + s.charAt(i) - '0';
                    numStack.push(pop);
                } else numStack.push(s.charAt(i) - '0');
            } else {
                if (s.charAt(i) == ']') {
                    int count = numStack.pop();
                    StringBuilder sb = new StringBuilder();
                    while (charStack.peek() != '[') {
                        sb.insert(0, charStack.pop());
                    }
                    charStack.pop();
                    for (int j = 0; j < count; j++) {
                        for (int k = 0; k < sb.length(); k++) {
                            charStack.push(sb.charAt(k));
                        }
                    }
                } else {
                    charStack.push(s.charAt(i));
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!charStack.isEmpty()) {
            stringBuilder.insert(0, charStack.pop());
        }
        return stringBuilder.toString();
    }
}
