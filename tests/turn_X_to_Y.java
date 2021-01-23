package tests;

public class turn_X_to_Y {
    public static void main(String[] args) {
        String x = "abcdefh";
        String y = "bcefg";
        System.out.println(LCS(x, y));
       X_to_Y_count(x,y);
    }

    public static String LCS(String x, String y) {
        int x_length = x.length() + 1;
        int y_length = y.length() + 1;
        int[][] mat = new int[x_length][y_length];

        for (int i = 1; i <= x_length-1; i++) {
            for (int j = 1; j <= y_length-1; j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    mat[i][j] = mat[i - 1][j - 1] + 1;
                } else  mat[i][j] = Math.max(mat[i - 1][j], mat[i][j - 1]);
            }
        }

        int i = x.length(), j = y.length();
        String ans = "";
        while (i > 0 && j > 0) {
            if (x.charAt(i - 1) == y.charAt(j - 1)) {
                ans = x.charAt(i-1) + ans;
                i--;
                j--;
            } else {
                if (mat[i][j - 1] > mat[i - 1][j])
                    j--;
                else i--;
            }
        }
        return ans;
    }

    public static void X_to_Y_count(String x, String y){
        String lcs = LCS(x,y);
        int lcs_length = lcs.length();
        System.out.println("Delete " + (x.length() - lcs_length) + " chars");
        System.out.println("Add " + (y.length() - lcs_length) + " chars");
    }

}
