package egg_drop;

import java.util.Arrays;

public class asi_egg_drop {
/**
 * A Dynamic Programming based Java
 * Program for the glass Dropping Puzzle
 * complexity: o(n * k^2) + o(n * k)
 */

    /**
     * Function to get minimum number of trials needed in worst
     * case with n eggs and k floors.
     *
     * @param floors eggs
     * @param balls  floors
     * @return int representing tries taken to find floor.
     */
    static int glass_ball_drop(int balls,int floors) {
        /* A 2D table where entry eggFloor[i][j]
            will represent minimum number of trials
            needed for i eggs and j floors. */
        int min_tries; // will be the answer
        // this matrix will represent num of tries for each floor with each ball
        int[][] ball_floor = new int[floors + 1][balls + 1];

        int i = 0;// set the zero floor and 1st floor to 0 and 1 num of tries
        while (i < floors + 1) {
            ball_floor[i][0] = 0;
            ball_floor[i][1] = 1;
            i++;
        }
        for (int j = 1; j <= balls; j++)
            ball_floor[1][j] = j; //when you have only 1 ball , for each n floor you need n tries

        int start_floor = 0, last_floor = 0;
        for (i = 2; i < floors + 1; i++) { // triangle numbers --> start at 3 floor
            for (int j = 2; j < balls + 1; j++) {
                ball_floor[i][j] = (int) Double.POSITIVE_INFINITY;
                for (int f = 1; f < j + 1; f++) {
                    min_tries = Math.max(ball_floor[i][j - f], ball_floor[i - 1][f - 1]) + 1; // choose between - and ball was broken or not
                    if (min_tries < ball_floor[i][j]) {
                        ball_floor[i][j] = min_tries; // looking for the minimal options
                        if (i == floors && j == balls) start_floor = f;
                    }
                    if (min_tries == ball_floor[i][j]) {
                        ball_floor[i][j] = min_tries;
                        if (i == floors && j == balls) last_floor = f;
                    }
                }
            }
        }
        for (int[] ints : ball_floor) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println(start_floor);
        System.out.println(last_floor);

        // eggFloor[n][k] holds the result
        return ball_floor[floors][balls];
    }

    /* Driver program to test to pront printDups*/
    public static void main(String[] args) {
        int n =4, k = 100;
        System.out.println("Minimum number of trials in worst case with "
                + n + " eggs and "
                + k + " floors is: " + glass_ball_drop(k, n));
    }
}