package egg_drop;

public class egg_drop_2 {
    public static void k_checks(int balls, int levels) {
        int numChecks = 0, min, max, broked, unbroke, count = 0;
        int[][] mat = new int[balls + 1][levels + 1];
//init
        for (int j = 0; j <= levels; ++j) {
            mat[0][j] = 0; //no ball - no checks
            mat[1][j] = j; // 1 ball - only whole search is suitable
        }
//build mat
        for (int i = 2; i < balls + 1; ++i) {
            mat[i][0] = 0;
            mat[i][1] = 1;
            if (levels >= 2) {
                mat[i][2] = 2;
            }
//
            for (int j = 2; j <= levels; ++j) {
                min = levels + 1;
//
                for (int p = 1; p <= j - 1; ++p) {
// the ball broke on level i, so check the levels below with one less ball
                    broked = mat[i - 1][p - 1];
// the ball wasn’t broken on level i, so check the level above with same ball number
                    unbroke = mat[i][j - p];
// take the worst case
                    max = Math.max(broked, unbroke);
// take the best step
                    min = Math.min(max, min) + 1;
                    mat[i][j] = min;
                }
            }
            System.out.println("num of checks for " + balls + " balls and " + levels + " levels is: " + mat[balls][levels]);
        }
    }
}
