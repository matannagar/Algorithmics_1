package tests;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LCS_size_K {
    public static void main(String[] args) {
        String X = "ABCDAE";
        String Y = "BCADB";
        //another example: x = abcabcaa, y = acbacba

        //calculate matrix
        int[][] mat = LCS(X, Y, 2);

        //print matrix after calculate
        Print(mat);

        //print the LCS
        System.out.println("Longest Commom Subsequence = " + mat[X.length()][Y.length()]);

        //print example of subsequence
//        String subsequence = GetSubsequence(X, Y, Mat);
//        System.out.println("Example of Common Subsequence = " + subsequence);

        //Get all subsequences
//        int startI = X.length();
//        int startJ = Y.length();
       String subsequence = "";
        ArrayList<String> allSubSequences = new ArrayList<>();//there can be duplicated so Set is chosen
        ArrayList<Point> search_here = LCS_list(X,Y,2);

//        int k = 3;
        //calculate all subsequences
//        for (int i = 0; i < mat.length; i++) {
//            for (int j = 0; j < mat[0].length; j++) {
//                if (mat[i][j]==2)  search_here.add(new Point(i, j));
//            }
//        }
        for (int i = 0; i < search_here.size(); i++) {
            int x = search_here.get(i).x;
            int y = search_here.get(i).y;
            GetAllSubSequences(X, Y, mat, x, y, subsequence, allSubSequences);
        }
//        System.out.println(getAllSQ(X,Y));
        //print all subsequences
        List<String> newlist = allSubSequences.stream().distinct().collect(Collectors.toList());
        System.out.println(newlist);
    }

    private static int[][] LCS(String x, String y, int k) {
        ArrayList<Point> search_here = new ArrayList<>();

        //define matrix size, everything set to zero
        int[][] Mat = new int[x.length() + 1][y.length() + 1];

        for (int i = 1; i <= x.length(); i++) {
            for (int j = 1; j <= y.length(); j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    //add from the diagonal corner
                    Mat[i][j] = Mat[i - 1][j - 1] + 1;
                } else//choose the max size from top or left size
                {
                    Mat[i][j] = Math.max(Mat[i][j - 1], Mat[i - 1][j]);
                }
                if (Mat[i][j] == k) search_here.add(new Point(i, j));
            }
        }
        return Mat;
    }

    private static ArrayList<Point> LCS_list(String x, String y, int k) {
        ArrayList<Point> search_here = new ArrayList<>();

        //define matrix size, everything set to zero
        int[][] Mat = new int[x.length() + 1][y.length() + 1];

        for (int i = 1; i <= x.length(); i++) {
            for (int j = 1; j <= y.length(); j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    //add from the diagonal corner
                    Mat[i][j] = Mat[i - 1][j - 1] + 1;
                } else//choose the max size from top or left size
                {
                    Mat[i][j] = Math.max(Mat[i][j - 1], Mat[i - 1][j]);
                }
                if (Mat[i][j] == k ||Mat[i][j] == k+1) search_here.add(new Point(i, j));
            }
        }
        return search_here;
    }

    public static ArrayList<String> getAllSQ(String X, String Y, int k) {
        ArrayList<String> allSubSequences = new ArrayList<>();
        GetAllSubSequences(X, Y, LCS(X, Y, k), X.length(), Y.length(), "", allSubSequences);
        List<String> newlist = allSubSequences.stream().distinct().collect(Collectors.toList());
        return (ArrayList<String>) newlist;
    }

    private static void GetAllSubSequences(String x, String y, int[][] mat, int i, int j, String ans, ArrayList<String> allSubSequences) {
        while (i > 0 && j > 0) { //both indexes start at the end of the matrix
            if (x.charAt(i - 1) == y.charAt(j - 1)) { // if we find two characters that are the same
                ans = x.charAt(i - 1) + ans;
                i = i - 1; //move the element to the diagonal corner
                j = j - 1;
            } else {
                if (mat[i - 1][j] > mat[i][j - 1]) // now we are searching for the next biggest substring
                    i--;
                else if (mat[i - 1][j] < mat[i][j - 1])
                    j--;
                else { // if they are both equal then we have two substring of the same size, split.
                    GetAllSubSequences(x, y, mat, i - 1, j, ans, allSubSequences);
                    GetAllSubSequences(x, y, mat, i, j - 1, ans, allSubSequences);
                    return;
                }
            }
        }
        allSubSequences.add(ans);

    }

    private static void Print(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(mat[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
