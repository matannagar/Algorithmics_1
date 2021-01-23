package tests.LCS;

public class SCS {
    public static void main(String[] args) {
        String X = "abcbdab";
        String Y = "bdcaba";
        //another example: x = abcabcaa, y = acbacba
        System.out.println(SCS_int(X, Y));
        //print the LCS
        System.out.println("Longest Commom Subsequence = " + LCS(X, Y));
        System.out.println(LCS_Sequence(X, Y, LCS_mat(X, Y)));
        System.out.println(SCS(X, Y));
        ;
    }

    /**
    returns length of longest common super sequence of both strings
     */
    public static int SCS_int(String x, String y) {
        return x.length() + y.length() - LCS(x, y);
    }
    /**
     returns an example of SCS
     */
    public static StringBuilder SCS(String x, String y) {
        String lcs = LCS_Sequence(x, y, LCS_mat(x, y));
        int i = 0, j = 0, k = 0;
        StringBuilder scc = new StringBuilder();

        while (i < x.length() && j < y.length() && k < lcs.length()) {
            if (x.charAt(i) == y.charAt(j) && x.charAt(i) == lcs.charAt(k)) {
                scc.append(lcs.charAt(k));
                i++;
                j++;
                k++;
            } else if (x.charAt(i) == lcs.charAt(k) && x.charAt(i) != y.charAt(j)) {
                scc.append(y.charAt(j));
                j++;
            }
            if (k < lcs.length()) {
                if (x.charAt(i) != lcs.charAt(k)) {
                    scc.append(x.charAt(i));
                    i++;
                }
                 if (k==lcs.length()-1){
                    while (i<x.length()-1){
                        scc.append(x.charAt(i));
                        i++;
                    }
                    while (j<y.length()-1){
                        scc.append(y.charAt(j));
                        j++;

                    }
                }
            }
        }
        return scc;
    }

    public static int LCS(String x, String y) {
        int[][] mat = new int[x.length() + 1][y.length() + 1];
        for (int i = 1; i <= x.length(); i++) {
            for (int j = 1; j <= y.length(); j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    mat[i][j] = mat[i - 1][j - 1] + 1;
                } else {
                    mat[i][j] = Math.max(mat[i - 1][j], mat[i][j - 1]);
                }
            }
        }
        return mat[x.length()][y.length()];
    }

    public static int[][] LCS_mat(String x, String y) {
        int[][] mat = new int[x.length() + 1][y.length() + 1];
        for (int i = 1; i <= x.length(); i++) {
            for (int j = 1; j <= y.length(); j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    mat[i][j] = mat[i - 1][j - 1] + 1;
                } else {
                    mat[i][j] = Math.max(mat[i - 1][j], mat[i][j - 1]);
                }
            }
        }
        return mat;
    }

    private static String LCS_Sequence(String x, String y, int[][] mat) {
        int i = x.length();
        int j = y.length();
        String ans = "";
        while (i > 0 && j > 0) {
            if (x.charAt(i - 1) == y.charAt(j - 1)) {
                ans = x.charAt(i - 1) + ans;
                i = i - 1;
                j = j - 1;
            } else {
                if (mat[i - 1][j] > mat[i][j - 1])
                    i--;
                else
                    j--;
            }
        }
        return ans;
    }
}
