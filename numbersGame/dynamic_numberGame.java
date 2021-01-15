package numbersGame;

public class dynamic_numberGame {

    public static void main(String[] args) {
        dynamic_numberGame my_game = new dynamic_numberGame(new int[]{11, 3, 6, 11, 4, 2, 8, 10});
        System.out.println(my_game.getOptimalPathRec());
        int sum = 11+3+6+11+4+2+8+10;
        System.out.println("player b:" + (sum - my_game.getDifference())/2);
        int b = (sum - my_game.getDifference())/2 + my_game.getDifference();
        System.out.println("player a:" + b);
    }

    /**
     * Game Numbers - dynamic algorithm
     * Complexity: O(n^2)
     */

    private int[][] mat;
    private int n;

    public dynamic_numberGame(int[] a) {
        buildMatrix(a);
    }

    /**
     * creates a matrix, putting at [i,i] the array numbers
     * afterwards for the first part of the game, after diagonal is settled
     * at the spot mat[i][j] (top triangle) place the best difference between each two neighbor numbers.
     *
     * @param a
     */
    public void buildMatrix(int[] a) {
        n = a.length;
        mat = new int[n][n];
        for (int i = 0; i < n; i++) {
            //diagonal line
            mat[i][i] = a[i];
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                mat[i][j] = Math.max(mat[i][i] - mat[i + 1][j], mat[j][j] - mat[i][j - 1]);
//                    System.out.println("mat["+i+"]["+i+"]="+mat[i][j]);
//                    System.out.println(mat[i][i] +" "+ mat[i+1][j]+" or "+ mat[j][j] +" "+ mat[i][j-1]);
            }
        }
    }

    /**
     * Returns the difference between the first player and the second player
     * if both playing optimal
     */
    public int getDifference() {
        return mat[0][mat[0].length - 1];
    }

    public String getOptimalPathRec() {
        return getOptimalPath(0, n - 1);
    }

    /**
     * Returns the game's optimal path for both players
     */
    private String getOptimalPath(int i, int j) {
        if (i == j) return "(" + i + ")" + mat[i][i];
        if (mat[i][i] - mat[i + 1][j] > mat[j][j] - mat[i][j - 1]) {
            return "(" + i + ")" + mat[i][i] + "->" + getOptimalPath(i + 1, j);
        } else {
            return "(" + j + ")" + mat[j][j] + "->" + getOptimalPath(i, j - 1);
        }
    }
}
