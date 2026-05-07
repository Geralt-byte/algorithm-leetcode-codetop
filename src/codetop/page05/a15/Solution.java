package codetop.page05.a15;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author mlei@xjtu
 * @description 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 * 整数除法仅保留整数部分。
 * 你可以假设给定的表达式总是有效的。所有中间结果将在 [-231, 231 - 1] 的范围内。
 * 注意：不允许使用任何将字符串作为数学表达式计算的内置函数，比如 eval() 。
 * @create 2026/5/7 14:54
 */
public class Solution {
    public int calculate(String s) {
        if (s.length() == 1) return Integer.parseInt(s);
        Deque<Character> operateStack = new ArrayDeque<>();
        Deque<Long> numStack = new ArrayDeque<>();
        int index = 0;
        while (index < s.length()) {
            while (index < s.length() && s.charAt(index) == ' ') {
                index++;
            }
            if (index == s.length()) break;
            if (s.charAt(index) <= '9' && s.charAt(index) >= '0') {
                index = getNextNum(s, index, numStack);
            } else if (s.charAt(index) == '+' || s.charAt(index) == '-') {
                operateStack.push(s.charAt(index));
                index++;
            } else if (s.charAt(index) == '*') {
                index++;
                while (index < s.length() && s.charAt(index) == ' ') {
                    index++;
                }
                index = getNextNum(s, index, numStack);
                long b = numStack.pop();
                long a = numStack.pop();
                numStack.push(a * b);
            } else if (s.charAt(index) == '/') {
                index++;
                while (index < s.length() && s.charAt(index) == ' ') {
                    index++;
                }
                index = getNextNum(s, index, numStack);
                long b = numStack.pop();
                long a = numStack.pop();
                numStack.push(a / b);
            }
        }
        long result = numStack.removeLast();
        while (!operateStack.isEmpty()) {
            char operate = operateStack.removeLast();
            long next = numStack.removeLast();
            if (operate == '+') {
                result += next;
            } else result -= next;
        }
        return (int) result;
    }

    private int getNextNum(String s, int index, Deque<Long> numStack) {
        int start = index;
        while (index < s.length() && s.charAt(index) <= '9' && s.charAt(index) >= '0') {
            index++;
        }
        numStack.push(Long.parseLong(s.substring(start, index)));
        return index;
    }
}
