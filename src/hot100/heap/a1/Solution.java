package hot100.heap.a1;

import java.util.Arrays;

/**
 * @author mlei@xjtu
 * @description 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * @create 2026/3/25 20:46
 */
public class Solution {
    //小顶堆
    public int findKthLargest(int[] nums, int k) {
        //建堆
        int[] heap = buildHeap(nums, k);
        //不断插入剩余元素
        for (int i = k; i < nums.length; i++) {
            insert(heap,nums[i],k);
        }
//        System.out.println(Arrays.toString(heap));
        //堆顶元素为堆中最小的，也是第k大的元素
        return heap[1];
    }

    public int[] buildHeap(int[] nums,int k){
        //0位置不使用
        int[] heap = new int[k + 1];
        for (int i = 1; i < heap.length; i++) {
            heap[i]=nums[i-1];
        }
        //从最后一个非叶节点开始调整为小顶堆
        for (int i = k/2; i > 0; i--) {
            adjustHeap(heap,i,k);
        }
        return heap;
    }

    public void adjustHeap(int[] heap,int index,int n){
        //0位置用来做temp
        heap[0]=heap[index];
        //i从要调整节点的第一个子节点开始
        for (int i = index*2; i <= n; i*=2) {
            //寻找最小值的子节点
            if(i<n&&heap[i]>heap[i+1]){
                i++;
            }
            //当前位置比子节点中最小的更大
            if(heap[0]>heap[i]){
                //子节点向上提升
                heap[index]=heap[i];
                //将本来的节点放到提升后空出的位置，继续向下调整
                index=i;
            }
            //说明已经找到了index的存放位置
            else break;
        }
        //将原值存入
        heap[index]=heap[0];
    }

    public void insert(int[] heap,int num,int n){
        //比小顶堆中最小的元素更小，不存入
        if(num<=heap[1]) return;
        else {
            //用新元素代替堆顶元素，再调整为小顶堆
            heap[1]=num;
            adjustHeap(heap,1,n);
        }
    }
}
