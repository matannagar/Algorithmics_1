package tests;

import java.awt.*;

public class consecutive_LCS {
    public static void main(String[] args) {
        String X = "matangn";
        String Y = "atann";
        System.out.println(consecutive_lcs_example(X, Y));
    }

    public static Point LCS_consecutive(String x, String y) {
        Point ans = null;
        int[][] mat = new int[y.length() + 1][x.length() + 1];
        int max = 0;
        for (int i = 1; i < y.length(); i++) {
            for (int j = 1; j < x.length(); j++) {
                if (y.charAt(i - 1) == x.charAt(j - 1)) {
                    mat[i][j] = mat[i - 1][j - 1] + 1;
                    if (max < mat[i][j]) {
                        max = mat[i][j];
                        ans = new Point(i, j);
                    }
                }
            }
        }
        Print(mat);
        return ans;
//        return max;
    }

    private static void Print(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(mat[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static String consecutive_lcs_example(String x, String y) {
        Point ans = null;
        int[][] mat = new int[y.length() + 1][x.length() + 1];
        int max = 0;
        for (int i = 1; i < y.length(); i++) {
            for (int j = 1; j < x.length(); j++) {
                if (y.charAt(i - 1) == x.charAt(j - 1)) {
                    mat[i][j] = mat[i - 1][j - 1] + 1;
                    if (max < mat[i][j]) {
                        max = mat[i][j];
                        ans = new Point(i, j);
                    }
                }
            }
        }
        int i = ans.x;
        int j = ans.y;
        String s = "";
        while (mat[i][j] != 0) {
            s =  x.charAt(i)+s;
            i--;
            j--;
        }
        return s;
    }
}
