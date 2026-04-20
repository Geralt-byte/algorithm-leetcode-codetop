package codetop.page02.a18;

/**
 * @author mlei@xjtu
 * @description 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 * @create 2026/4/20 08:55
 */
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        if (len % 2 == 1) {
            return findMin(nums1, nums2, 0, 0, len / 2 + 1);
        } else {
            double a = findMin(nums1, nums2, 0, 0, len / 2);
            double b = findMin(nums1, nums2, 0, 0, len / 2 + 1);
            return (a + b) / 2;
        }
    }

    /*表示从两个数组中寻找第k大的数，index1和index2表示起始索引的下标*/
    private int findMin(int[] nums1, int[] nums2, int index1, int index2, int k) {
        while (true) {
            if (index1 == nums1.length) return nums2[index2 + k - 1];
            if (index2 == nums2.length) return nums1[index1 + k - 1];
            if (k == 1) return Math.min(nums1[index1], nums2[index2]);
            int nexIndex1 = Math.min(nums1.length, index1 + k / 2) - 1;
            int nexIndex2 = Math.min(nums2.length, index2 + k / 2) - 1;
            int pivot = Math.min(nums1[nexIndex1], nums2[nexIndex2]);
            if (pivot == nums1[nexIndex1]) {
                k -= nexIndex1 - index1 + 1;
                index1 = nexIndex1 + 1;
            } else {
                k -= nexIndex2 - index2 + 1;
                index2 = nexIndex2 + 1;
            }
        }
    }
}
