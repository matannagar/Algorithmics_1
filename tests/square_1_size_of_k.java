package tests;

public class square_1_size_of_k {
    public static void main(String[] args) {
        int[][] mat = {{1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1}};
        System.out.println(get_k_k_matrices(mat, 3));
    }

    public static void Print(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(mat[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static int get_k_k_matrices(int[][] mat, int bound) {
        int[][] count_mat = new int[mat.length][mat[0].length];
        int row = mat.length;
        int column = mat[0].length;
        int max = 1; // biggest square
        int i_index = 0, j_index = 0; // location of start matrix
        int count_size = 0;

        //fill the first row
        for (int i = 0; i < row; i++) {
            count_mat[i][0] = mat[i][0];
        }
        //fill the first column
        for (int i = 0; i < column; i++) {
            count_mat[0][i] = mat[0][i];
        }

        //dirty work of marking
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                if (mat[i][j] == 1) {
                    count_mat[i][j] = 1 + Math.min(Math.min(count_mat[i - 1][j], count_mat[i][j - 1]), count_mat[i - 1][j - 1]);
                    if (count_mat[i][j] == bound) count_size++;
                    if (count_mat[i][j] > max) {
                        max = count_mat[i][j];
                        i_index = i - max + 1;
                        j_index = j - max + 1;
                    }
                }
            }
        }
        System.out.println("(" + i_index + "," + j_index + ")");
        Print(count_mat);
        return count_size;
    }
}
