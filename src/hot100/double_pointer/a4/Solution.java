package hot100.double_pointer.a4;

/**
 * @author mlei@xjtu
 * @description 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * @create 2026/3/18 16:49
 */
public class Solution {
    public int trap(int[] height) {
        if (height.length < 3) return 0;
        int left = 0, right = height.length - 1;
        int result = 0;
        while (left < right) {
            while (left < right && height[left] == 0) left++;
            while (left < right && height[right] == 0) right--;
            if (height[left] <= height[right]) {
                int index = left + 1;
                while (index < right && height[index] < height[left]) {
                    result += height[left] - height[index];
                    index++;
                }
                left = index;
            } else {
                int index = right - 1;
                while (index > left && height[index] < height[right]) {
                    result += height[right] - height[index];
                    index--;
                }
                right = index;
            }
        }
        return result;
    }
}
