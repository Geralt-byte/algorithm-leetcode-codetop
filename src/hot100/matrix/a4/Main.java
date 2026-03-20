package hot100.matrix.a4;

/**
 * @author mlei@xjtu
 * @description Main
 * @create 2026/3/21 02:24
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix=new int[][]{{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
        System.out.println(solution.searchMatrix(matrix,19));
    }
}
/*
* {1,2,3,4,5}
* {6,7,8,9,10}
* {11,12,13,14,15}
* {16,17,18,19,20}
* {21,22,23,24,25}
* */
