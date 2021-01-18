package tests;

public class LCS_3_strings {
    public static void main(String[] args) {
        String A = "ABCDEFGH";
        String B = "ACEG";
        String C = "AE";

        int[][][] ans = regular_lcs(A,B,C);
        System.out.println(ans[A.length()][B.length()][C.length()]);
    }
    //returns matrix of lcs
    public static int[][][] regular_lcs(String X, String Y, String Z) {
        int[][][] mat = new int[X.length() + 1][Y.length() + 1][Z.length() + 1]; // everything is already 0

        for (int i = 1; i <= X.length(); i++) {
            for (int j = 1; j <= Y.length(); j++) {
                for (int k = 1; k <= Z.length(); k++) {
                    if (X.charAt(i - 1) == Y.charAt(j - 1) && Y.charAt(j - 1) == Z.charAt(k - 1))
                        mat[i][j][k] = mat[i - 1][j - 1][k-1] + 1;
                    else mat[i][j][k] = Math.max((Math.max(mat[i][j][k-1],mat[i][j-1][k])),mat[i-1][j][k]);
                }
            }
        }
        return mat;
    }
    //starts from end and goes back to start
    public static String subSequence(int[][] mat, String X, String Y) {
        int i = X.length();
        int j = Y.length();
        String ans = "";

        while (i > 0 && j > 0) {
            if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                ans = X.charAt(i - 1) + ans;
                i--;
                j--;
            } else {
                if (mat[i - 1][j] > mat[i][j - 1])
                    i--;
                else
                    j--;
            }
        }
        return ans;
    }

//    public static String subSequence_3_Strings( char[] x, char[] y, char[] z){
//        int n = x.length +1;
//        int m = y.length +1;
//        int num = 0;
//        int[][] ans = new int[n][m];
//        int temp = 0;
//
//        for (int i = 0; i < ans.length; i++) {
//
//        }
//    }
}


