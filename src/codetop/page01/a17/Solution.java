package codetop.page01.a17;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author mlei@xjtu
 * @description 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 * @create 2026/4/16 13:54
 */
public class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            } else {
                if (s.charAt(i) == ')' && (stack.isEmpty() || stack.pop() != '(')) return false;
                if (s.charAt(i) == '}' && (stack.isEmpty() || stack.pop() != '{')) return false;
                if (s.charAt(i) == ']' && (stack.isEmpty() || stack.pop() != '[')) return false;
            }
        }
        return stack.isEmpty();
    }
}
