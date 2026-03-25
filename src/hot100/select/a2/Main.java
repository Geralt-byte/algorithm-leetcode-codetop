package hot100.select.a2;

/**
 * @author mlei@xjtu
 * @description Main
 * @create 2026/3/24 18:00
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix=new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        boolean b = solution.searchMatrix(matrix, 3);
        System.out.println(b);
    }
}
