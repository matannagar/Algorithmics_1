package LCS;
import java.util.HashSet;
import java.util.Set;

public class Dynamic_LCS {

    public static void main(String[] args) {
        String X = "ZBGCRDE";
        String Y = "YZGBCZD";
        //another example: x = abcabcaa, y = acbacba

        //calculate matrix
        int[][] Mat = LCS(X,Y);

        //print matrix after calculate
        Print(Mat);

        //print the LCS
        System.out.println("Longest Commom Subsequence = " + Mat[X.length()][Y.length()]);

        //print example of subsequence
        String subsequence = GetSubsequence(X, Y, Mat);
        System.out.println("Example of Common Subsequence = " + subsequence);

        //Get all subsequences
        int startI = X.length();
        int startJ = Y.length();
        subsequence = "";
        Set<String> allSubSequences = new HashSet<>();//there can be duplicated so Set is chosen

        //calculate all subsequences
        GetAllSubSequences(X, Y, Mat, startI, startJ, subsequence, allSubSequences);

        //print all subsequences
        System.out.println(allSubSequences);
    }

    /**
     *  	    a	b	c	d	e	f
     * a  i,j=1	0	0	0	0	0	0
     * b    0	0	0	0	0	0	0
     * c    0	0	0	0	0	0	0
     * d    0	0	0	0	0	0	0
     * e    0	0	0	0	0	0	0
     * f    0	0	0	0	0	0	0
     */
    private static int[][] LCS(String x, String y) {
        //define matrix size, everything set to zero
        int[][] Mat = new int[x.length()+1][y.length()+1];

        for (int i = 1; i <= x.length(); i++) {
            for (int j = 1; j <= y.length(); j++) {
                if (x.charAt(i-1)==y.charAt(j-1))
                {
                    //add from the diagonal corner
                    Mat[i][j] = Mat[i-1][j-1]+1;
                }
                else//choose the max size from top or left size
                    Mat[i][j] = Math.max(Mat[i][j-1], Mat[i-1][j]);
            }
        }
        return Mat;
    }
    private static String GetSubsequence(String x, String y, int[][] mat) {
        int i = x.length();
        int j = y.length();
        String ans = "";
        while (i>0 && j>0)
        {
            if (x.charAt(i-1)==y.charAt(j-1))
            {
                ans = x.charAt(i-1) + ans;
                i = i-1;
                j = j-1;
            }
            else
            {
                if (mat[i-1][j] > mat[i][j-1])
                    i--;
                else
                    j--;
            }
        }
        return ans;
    }
    private static void Print(int[][]  mat)
    {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(mat[i][j]+"\t");
            }
            System.out.println();
        }
    }
    private static void GetAllSubSequences(String x, String y, int[][] mat, int i, int j, String ans, Set<String> allSubSequences) {
        while(i>0 && j>0)
        {
            if (x.charAt(i-1)==y.charAt(j-1))
            {
                ans = x.charAt(i-1) + ans;
                i = i-1;
                j = j-1;
            }
            else
            {
                if (mat[i-1][j] > mat[i][j-1])
                    i--;
                else
                if (mat[i-1][j] < mat[i][j-1])
                    j--;
                else
                {
                    GetAllSubSequences(x,y,mat,i-1,j, ans, allSubSequences);
                    GetAllSubSequences(x,y,mat,i,j-1, ans, allSubSequences);
                    return;
                }
            }
        }
        allSubSequences.add(ans);

    }

}
