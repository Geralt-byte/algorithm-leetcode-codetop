package hot100.heap.a2;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author mlei@xjtu
 * @description 中位数是有序整数列表中的中间值。如果列表的大小是偶数，则没有中间值，中位数是两个中间值的平均值。
 * 例如 arr = [2,3,4] 的中位数是 3 。
 * 例如 arr = [2,3] 的中位数是 (2 + 3) / 2 = 2.5 。
 * 实现 MedianFinder 类:
 * MedianFinder() 初始化 MedianFinder 对象。
 * void addNum(int num) 将数据流中的整数 num 添加到数据结构中。
 * double findMedian() 返回到目前为止所有元素的中位数。与实际答案相差 10-5 以内的答案将被接受。
 * @create 2026/3/25 22:54
 */
class MedianFinder1 {

    private PriorityQueue<Integer> minQueue;
    private PriorityQueue<Integer> maxQueue;

    public MedianFinder1() {
        minQueue = new PriorityQueue<>();
        maxQueue = new PriorityQueue<>((a, b) -> b - a);
    }

    public void addNum(int num) {
        maxQueue.add(num);
        if(!maxQueue.isEmpty()&&!minQueue.isEmpty()&&maxQueue.peek()>minQueue.peek()){
            minQueue.add(maxQueue.poll());
        }
        if(maxQueue.size()-minQueue.size()>1){
            minQueue.offer(maxQueue.poll());
        }else if(minQueue.size()>maxQueue.size()){
            maxQueue.offer(minQueue.poll());
        }
    }

    //从大顶堆和小顶堆的根节点可以得到中位数
    public double findMedian() {
        if(maxQueue.size()>minQueue.size()){
            return maxQueue.peek();
        }else {
            return (maxQueue.peek()+minQueue.peek())/2.0;
        }
    }
}
