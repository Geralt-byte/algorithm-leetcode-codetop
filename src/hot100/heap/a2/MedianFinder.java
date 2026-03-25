package hot100.heap.a2;

import java.util.ArrayList;
import java.util.List;

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
class MedianFinder {

    //小顶堆存放更大的一半元素，大顶堆存放更小的一半元素
    private final List<Integer> minHeap;
    private final List<Integer> maxHeap;
    private int minSize;
    private int maxSize;

    public MedianFinder() {
        minHeap = new ArrayList<>();
        maxHeap = new ArrayList<>();
        //0位置不使用
        minHeap.add(0);
        maxHeap.add(0);
        minSize = 0;
        maxSize = 0;
    }

    public void addNum(int num) {
        //先插入大顶堆
        insertMax(num);
        //维持小顶堆中最小的元素大于大顶堆中最大的元素
        if (maxSize > 0 && minSize > 0 && maxHeap.get(1) > minHeap.get(1)) {
            int i = deleteMax();
            insertMin(i);
        }
        //调整两个堆的数量
        if (maxSize - minSize > 1) {
            int i = deleteMax();
            insertMin(i);
        } else if (minSize > maxSize) {
            int i = deleteMin();
            insertMax(i);
        }
    }

    //从大顶堆和小顶堆的根节点可以得到中位数
    public double findMedian() {
        if (maxSize > minSize) {
            return maxHeap.get(1);
        } else return (maxHeap.get(1) + minHeap.get(1)) / 2.0;
    }

    //交换索引节点
    private void swap(List<Integer> heap, int a, int b) {
        int temp = heap.get(a);
        heap.set(a, heap.get(b));
        heap.set(b, temp);
    }

    //调整以index为根节点的树为小顶堆
    private void adjustMinHeap(int index, int n) {
        int temp = minHeap.get(index);
        for (int i = index * 2; i <= n; i*=2) {
            if (i < n && minHeap.get(i) > minHeap.get(i + 1)) {
                i++;
            }
            if (temp > minHeap.get(i)) {
                minHeap.set(index, minHeap.get(i));
                index = i;
            } else break;
        }
        minHeap.set(index, temp);
    }

    //调整以index为根节点的树为大顶堆
    private void adjustMaxHeap(int index, int n) {
        int temp = maxHeap.get(index);
        for (int i = index * 2; i <= n; i*=2) {
            if (i < n && maxHeap.get(i) < maxHeap.get(i + 1)) {
                i++;
            }
            if (temp < maxHeap.get(i)) {
                maxHeap.set(index, maxHeap.get(i));
                index = i;
            } else break;
        }
        maxHeap.set(index, temp);
    }

    //将元素插入小顶堆
    private void insertMin(int num) {
        minHeap.add(num);
        minSize++;
        int i = minSize;
        while (i > 1) {
            if (minHeap.get(i) >= minHeap.get(i / 2)) break;
            else {
                swap(minHeap, i, i / 2);
                i /= 2;
            }
        }
    }

    //将元素插入大顶堆
    private void insertMax(int num) {
        maxHeap.add(num);
        maxSize++;
        int i = maxSize;
        while (i > 1) {
            if (maxHeap.get(i) <= maxHeap.get(i / 2)) break;
            else {
                swap(maxHeap, i, i / 2);
                i /= 2;
            }
        }
    }

    //从小顶堆中移除元素
    private int deleteMin() {
        int del = minHeap.get(1);
        minHeap.set(1, minHeap.get(minSize));
        minHeap.remove(minSize);
        minSize--;
        if (minSize > 0) adjustMinHeap(1, minSize);
        return del;
    }

    //从大顶堆中移除元素
    private int deleteMax() {
        int del = maxHeap.get(1);
        maxHeap.set(1, maxHeap.get(maxSize));
        maxHeap.remove(maxSize);
        maxSize--;
        if (maxSize > 0) adjustMaxHeap(1, maxSize);
        return del;
    }
}
