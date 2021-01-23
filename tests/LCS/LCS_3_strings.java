package tests.LCS;

public class LCS_3_strings {
    public static void main(String[] args) {
        String A = "ABCDEFGH";
        String B = "ACEG";
        String C = "AEG";

        int[][][] ans = regular_lcs(A,B,C);
        System.out.println(ans[A.length()][B.length()][C.length()]);
    }
    //returns matrix of lcs
    public static int[][][] regular_lcs(String x, String y, String z) {
        int[][][] mat = new int[x.length() + 1][y.length() + 1][z.length() + 1]; // everything is already 0

        for (int i = 1; i <= x.length(); i++) {
            for (int j = 1; j <= y.length(); j++) {
                for (int k = 1; k <= z.length(); k++) {
                    if (x.charAt(i - 1) == y.charAt(j - 1) && y.charAt(j - 1) == z.charAt(k - 1))
                        mat[i][j][k] = mat[i - 1][j - 1][k-1] + 1;
                    else mat[i][j][k] = Math.max((Math.max(mat[i][j][k-1],mat[i][j-1][k])),mat[i-1][j][k]);
                }
            }
        }
        int i = x.length(), j = y.length(), k = z.length();
        String ans = "";
        while ( i>0 && j>0 && k>0){
            if (x.charAt(i-1)==y.charAt(j-1) && y.charAt(j-1)==z.charAt(k-1)){
                ans = x.charAt(i-1) + ans;
                i--;j--;k--;
            }
            else{
                if (mat[i][j][k-1]>mat[i][j-1][k] && mat[i][j][k-1]>mat[i-1][j][k] ){
                    k--;
                }
                else if (mat[i][j-1][k]>mat[i][j][k-1] &&mat[i][j-1][k]>mat[i-1][j][k]){
                    j--;
                }
                else i--;
            }
        }
        System.out.println(ans);
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


