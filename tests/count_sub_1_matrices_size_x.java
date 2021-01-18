package tests;

public class count_sub_1_matrices_size_x {
    public static void main(String[] args) {
        int[][] mat = {{1, 1, 1},
                        {1, 1, 1},
                        {1, 1, 1}};

        System.out.println(get_num_of_sub_matrices_size_of_2(mat));
    }
    public static int get_num_of_sub_matrices_size_of_2(int[][] mat) {
        int row = mat.length;
        int column = mat[0].length;
        int[][] count_mat = new int[row][column];
        int counter = 0; //will count how many 2 we have in count_mat
        int max = 0, imax = 0, jmax = 0;

        // fill the first row of the help matrix
        for (int i = 0; i < row; i++) {
            count_mat[i][0] = mat[i][0];
        }
        //fill the columns of the help matrix
        for (int i = 0; i < row; i++) {
            count_mat[0][i] = mat[0][i];
        }

        /**
         * now we will count the squares of one,
         * and add to counter every time we find a square size of 2
         */
        for (int i = 1; i<row; i++){
            for(int j= 1; j<column; j++){
                if(mat[i][j]==1){
                    count_mat[i][j] = Math.min(mat[i-1][j-1],Math.min(mat[i-1][j],mat[i][j-1]))+1;
                    if(count_mat[i][j]==3 || count_mat[i-1][j]==3 || count_mat[i][j-1]==3 || count_mat[i-1][j-1]==3) counter++;
                }
            }
        }
        return counter;
    }
}
