package hot100.heap.a1;

import java.util.Arrays;

/**
 * @author mlei@xjtu
 * @description Main
 * @create 2026/3/25 21:53
 */
public class Main {
    public static void main(String[] args) {
        //堆排序
        Solution solution = new Solution();
        int[] ints = {3,2,3,1,2,4,5,5,6,54,23,1,43};
        int[] heap = solution.buildHeap(ints, 13);
        for (int i = 0; i < 13; i++) {
            int temp=heap[13-i];
            heap[13-i]=heap[1];
            heap[1]=temp;
            solution.adjustHeap(heap,1,12-i);
        }
        System.out.println(Arrays.toString(heap));
    }
}
