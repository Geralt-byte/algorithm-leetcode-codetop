package codetop.page01.a4;

/**
 * @author mlei@xjtu
 * @description 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * @create 2026/4/11 19:14
 */
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        int[] heap = buildHeap(nums, k);
        for (int i = k; i < nums.length; i++) {
            if(nums[i]>heap[1]){
                heap[1]=nums[i];
                AdjustHeap(heap,1);
            }
        }
        return heap[1];
    }

    private int[] buildHeap(int[] nums, int k) {
        int[] heap = new int[k+1];
        for (int i = 0; i < k; i++) {
            heap[i+1]=nums[i];
        }
        for (int i = (heap.length-1)/2; i >0; i--) {
            AdjustHeap(heap,i);
        }
        return heap;
    }

    private void AdjustHeap(int[] heap, int i) {
        heap[0] = heap[i];
        for (int k = i * 2; k < heap.length; k *= 2) {
            if (k < heap.length - 1 && heap[k] > heap[k + 1]) {
                k++;
            }
            if (heap[k] < heap[0]) {
                heap[i] = heap[k];
                i = k;
            } else {
                break;
            }
        }
        heap[i] = heap[0];
    }
}
