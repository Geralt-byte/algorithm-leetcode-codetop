package hot100.select.a6;

/**
 * @author mlei@xjtu
 * @description 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 * @create 2026/3/24 18:00
 */
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int sumLength = nums1.length + nums2.length;
        if (sumLength % 2 == 1) {
            return findMid(nums1, nums2, 0, 0, sumLength / 2+1);
        } else {
            double a = findMid(nums1, nums2, 0, 0, sumLength / 2);
            double b = findMid(nums1, nums2, 0, 0, sumLength / 2+1);
            return (a + b) / 2.0;
        }
    }

    private double findMid(int[] nums1, int[] nums2, int index1, int index2, int k) {
        while (true) {
            if (index1 == nums1.length) {
                return nums2[index2 + k-1];
            }
            if (index2 == nums2.length) {
                return nums1[index1 + k-1];
            }
            if (k == 1) return Math.min(nums1[index1], nums2[index2]);
            int newIndex1 = Math.min(index1 + k / 2, nums1.length) - 1;
            int newIndex2 = Math.min(index2 + k / 2, nums2.length) - 1;
            int pivot = Math.min(nums1[newIndex1], nums2[newIndex2]);
            if (pivot == nums1[newIndex1]) {
                k -= (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            } else {
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }
    }
}
