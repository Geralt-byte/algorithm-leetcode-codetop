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
class MinStack1 {

    private final List<Long> stack;
    private long min;


    public MinStack1() {
        stack = new ArrayList<>();
        min = 0L;
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.add(0L);
            min = val;
        } else {
            long diff = val - min;
            stack.add(diff);
            if (diff < 0) {
                min = val;
            }
        }
    }

    public void pop() {
        long pop = stack.remove(stack.size() - 1);
        if (pop < 0) {
            min = min - pop;
        }
    }

    public int top() {
        long peek = stack.get(stack.size() - 1);
        if (peek < 0) return (int) min;
        else return (int) (peek + min);
    }

    public int getMin() {
        return (int) min;
    }
}
