package tests;

public class fib_nlogn {
    public static int efficient_fib(int n) {
        int[][] matrix = {{1, 1}, {1, 0}};
        int[][] ans = fibRecursive(matrix, n - 1);
        return ans[0][0];
    }

    public static int[][] fibRecursive(int[][] mat, int index) {
        int[][] matrix = {{1, 1}, {1, 0}};
        if (index == 0) return matrix;

        else if (index%2==0) return fibRecursive(mul_mat(matrix,matrix),(index)/2);
        else return mul_mat(matrix,fibRecursive(mul_mat(matrix,matrix),(index-1)/2));
    }
    public static int[][] mul_mat(int[][] mat1, int[][] mat2) {
        int[][] matAns = new int[2][2];
        matAns[0][0] = mat1[0][0]*mat2[0][0] + mat1[0][1]*mat2[1][0];
        matAns[0][1] = mat1[0][0]*mat2[0][1] + mat1[0][1]*mat2[1][1];
        matAns[1][0] = mat1[1][0]*mat2[0][0] + mat1[1][1]*mat2[1][0];
        matAns[1][1] = mat1[1][0]*mat2[0][1] + mat1[1][1]*mat2[1][1];
        return matAns;
    }
}
