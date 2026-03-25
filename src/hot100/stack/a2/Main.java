package hot100.stack.a2;

/**
 * @author mlei@xjtu
 * @description Main
 * @create 2026/3/25 15:32
 */
public class Main {
    public static void main(String[] args) {
        MinStack1 minStack = new MinStack1();
        minStack.push(2);
        minStack.push(0);
        minStack.push(3);
        minStack.push(0);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}
