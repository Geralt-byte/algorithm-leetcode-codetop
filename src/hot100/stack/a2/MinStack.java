package hot100.stack.a2;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
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
 * @create 2026/3/25 14:56
 */
class MinStack {

    private final List<Integer> stack;
    private final Deque<Integer> minDeque;

    public MinStack() {
        this.stack=new ArrayList<>();
        this.minDeque=new LinkedList<>();
    }

    public void push(int val) {
        stack.add(val);
        if(minDeque.isEmpty()||val<stack.get(minDeque.peek())){
            minDeque.push(stack.size()-1);
        }
    }

    public void pop() {
        if(minDeque.peek()==stack.size()-1){
            minDeque.pop();
        }
        stack.remove(stack.size() - 1);
    }

    public int top() {
        return stack.get(stack.size() - 1);
    }

    public int getMin() {
        return stack.get(minDeque.peek());
    }
}
