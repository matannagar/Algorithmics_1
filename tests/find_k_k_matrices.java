package tests;

public class find_k_k_matrices {
    public static void main(String[] args) {
        int[][] mat =  {{1, 1, 1, 1},
                        {1, 1, 1, 1},
                        {1, 1, 1, 1},
                        {1, 1, 1, 1}};
        System.out.println(get_k_k_matrices(mat, 3));
    }

    /**
     *returns num of K*K squares in the matrix
     */
    public static int get_k_k_matrices(int[][] mat, int bound) {
        int[][] count_mat = new int[mat.length][mat[0].length];//initialize the matrix (doesnt have to be square
        int row = mat.length; //down
        int column = mat[0].length; // right
        int max = 0; // biggest square
        int i_index = 0, j_index = 0; // location of start biggest matrix
        int k_k_matrices = 0;

        //fill the first row
        for (int i = 0; i < row; i++) {
            count_mat[i][0] = mat[i][0];
            if (count_mat[i][0] >= bound) k_k_matrices++;
        }
        //fill the first column
        for (int i = 0; i < column; i++) {
            count_mat[0][i] = mat[0][i];
            if (count_mat[0][i] >= bound) k_k_matrices++;
        }

        //dirty work of marking
        for (int i = 1; i < row; i++) { // for in for to loop through the entire matrix except boundaries
            for (int j = 1; j < column; j++) {
                if (mat[i][j] == 1) { // only if 1 is found
                    //count_mat calculates the min size of top, left, or diagonal square and adds to it
                    count_mat[i][j] = 1 + Math.min(Math.min(count_mat[i - 1][j], count_mat[i][j - 1]), count_mat[i - 1][j - 1]);
                    if (count_mat[i][j] >= bound) k_k_matrices++; //if a square bigger or equals to size of k is found add to count_k_k
                    if (count_mat[i][j] > max) { //updates max size and index
                        max = count_mat[i][j];
                        i_index = i - max + 1;
                        j_index = j - max + 1;
                    }
                }
            }
        }
        if (mat[0][0] >= bound) k_k_matrices=k_k_matrices-1;
        System.out.println("(" + i_index + "," + j_index + ")");
        Print(count_mat);
        return k_k_matrices;
    }

    /**
     * prints the matrix
     */
    public static void Print(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(mat[i][j] + "\t");
            }
            System.out.println();
        }
    }

}
