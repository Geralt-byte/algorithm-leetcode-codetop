package codetop.page02.a11;

/**
 * @author mlei@xjtu
 * @description 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * @create 2026/4/19 08:20
 */
public class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if (n < 3) return 0;
        int left = 0, right = n - 1;
        while (left<=right&&height[left] == 0) left++;
        while (left<=right&&height[right] == 0) right--;
        int result = 0;
        while (left < right) {
            if (height[left] <= height[right]) {
                int index = left + 1;
                while (index <= right && height[index] <= height[left]) {
                    result += Math.max(height[left] - height[index], 0);
                    index++;
                }
                left = index;
            } else {
                int index = right - 1;
                while (index >= left && height[index] <= height[right]) {
                    result += Math.max(height[right] - height[index], 0);
                    index--;
                }
                right = index;
            }
        }
        return result;
    }
}
