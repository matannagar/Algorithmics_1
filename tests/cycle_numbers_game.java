package tests;

public class cycle_numbers_game {
    public static void main(String[] args) {
        System.out.println("max profit " + cycle_num_game_mod(new int[]{1, 2, 10, 6, 12}));
        ;
    }

    public static int numbers_game(int[] arr) {
        int[][] mat = new int[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            mat[i][i] = arr[i];
        }
        for (int i = arr.length - 2; i >= 0; i--) {
            for (int j = i + 1; j < arr.length; j++) {
                mat[i][j] = Math.max(mat[i][i] - mat[i + 1][j], mat[j][j] - mat[i][j - 1]);
            }
        }
        return mat[0][arr.length - 1];
    }

    public static int cycle_num_game(int[] arr) {
        int[] temp = new int[arr.length];
        int j, steps, max = 0;
        for (int i = 0; i < arr.length; i++) {
            steps = 0;
            j = i;
            while (steps < arr.length) {
                temp[steps++] = arr[j++];
                if (j == arr.length) j = 0;
            }
            if (steps == arr.length) {
                if (numbers_game(temp) > max) {
                    max = numbers_game(temp);
                }
            }
        }
        return max;
    }

    public static int cycle_num_game_mod(int[] arr) {
        int[] temp = new int[arr.length];
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                temp[(i + j) % arr.length] = arr[j];
                if (numbers_game(temp) > max) {
                    max = numbers_game(temp);
                }
            }
        }
        return max;
    }
}
