package tests;

public class numbers_game {
    public static void main(String[] args) {
        int[] game ={2,8,7,4};
        System.out.println( get_best_path(best_player(game)));
    }
    //creates matrix with best options for both players
    public static int[][] best_player(int[] arr){
        int[][] my_mat = new int[arr.length][arr.length];
        //place diagonal game
        for (int i = 0; i < arr.length; i++) {
        my_mat[i][i] = arr[i];
        }

        //calculate best results
        for (int i = arr.length-2; i >= 0; i--) {
            for (int j = i +1; j < arr.length; j++) {
                my_mat[i][j]=Math.max(my_mat[i][i]-my_mat[i+1][j],my_mat[j][j]-my_mat[i][j-1]);
            }
        }
        return my_mat;
    }
    //function to return course of the game
    public static String get_best_path(int[][] game){
        return get_best_path_rec(game,0,game.length-1);
    }

    private static String get_best_path_rec(int[][] game, int i, int j) {
    if (i==j) return "(" + i + ")"+game[i][i];

    if(game[i][i] - game [i+1][j]> game[j][j]-game[i][j-1]){
        return "(" + i + ")"+game[i][i] + "-->" +get_best_path_rec(game,i+1,j);
    }
    else return "(" + j + ")" + game[j][j] + "->" + get_best_path_rec(game,i, j - 1);
    }
}
