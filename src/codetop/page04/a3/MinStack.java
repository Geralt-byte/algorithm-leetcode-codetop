package codetop.page04.a3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mlei@xjtu
 * @description 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * 实现 MinStack 类:
 * MinStack() 初始化堆栈对象。
 * void push(int val) 将元素val推入堆栈。
 * void pop() 删除堆栈顶部的元素。
 * int top() 获取堆栈顶部的元素。
 * int getMin() 获取堆栈中的最小元素。
 * @create 2026/4/27 07:50
 */
class MinStack {

    private final List<Integer> stack;
    private final List<Integer> minStack;

    public MinStack() {
        stack = new ArrayList<>();
        minStack = new ArrayList<>();
    }

    public void push(int val) {
        stack.add(val);
        if (minStack.isEmpty() || val <= stack.get(minStack.get(minStack.size() - 1))) {
            minStack.add(stack.size() - 1);
        }
    }

    public void pop() {
        if (minStack.get(minStack.size() - 1) == stack.size() - 1) {
            minStack.remove(minStack.size() - 1);
        }
        stack.remove(stack.size() - 1);
    }

    public int top() {
        return stack.get(stack.size() - 1);
    }

    public int getMin() {
        return stack.get(minStack.get(minStack.size() - 1));
    }
}
