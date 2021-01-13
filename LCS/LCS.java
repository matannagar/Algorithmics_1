package LCS;

// Or Kadrawi
public class LCS {

    public static void main(String[] args) {
        String X = "abcdbca";
        String Y = "ecabdc";

        //String X = "ezcbdacba";
        //String Y = "bckeadcba";

        GreedyLCS(X,Y);
        ImprovedGreedyLCS(X,Y);
        FullSearchLCS(X,Y);
    }

    private static void GreedyLCS(String x, String y) {
        int ans1 = 0;
        String subsequence1 = "";
        int start1 = 0;
        for (int i = 0; i < x.length(); i++) {
            for (int j = start1; j < y.length(); j++) {
                if (x.charAt(i)==y.charAt(j))
                {
                    subsequence1 += x.charAt(i);
                    ans1++;
                    start1 = j+1;
                    break;
                }
            }
        }

        int ans2 = 0;
        String subsequence2 = "";
        int start2 = 0;
        for (int i = 0; i < y.length(); i++) {
            for (int j = start2; j < x.length(); j++) {
                if (y.charAt(i)==x.charAt(j))
                {
                    subsequence2 += y.charAt(i);
                    ans2++;
                    start2 = j+1;
                    break;
                }
            }
        }
        if (ans1 > ans2)
        {
            System.out.println("Greedy:\t\t subsequence = " + subsequence1 + ", LCS = " + ans1);
        }
        else
        {
            System.out.println("Greedy:\t\t subsequence = " + subsequence2 + ", LCS = " + ans2);
        }
    }
    private static void ImprovedGreedyLCS(String x, String y) {
        // In this implementation, we choose to start from the smallest string,
        // because it is more efficient to insert to the help array the longest string

        //make X to be the longest string.
        String temp;
        if (y.length() > x.length())
        {
            temp = y;
            y = x;
            x = temp;
        }

        int[] help = new int[26];
        for (int i = 0; i < x.length(); i++) {
            help[x.charAt(i)-'a']++;
        }
        int j = 0;
        String subsequence = "";
        int lcs = 0;
        for (int i = 0; i < y.length() && j < x.length(); i++) {
            if (help[y.charAt(i)-'a'] > 0)
            {
                while (x.charAt(j) != y.charAt(i))
                {
                    help[x.charAt(j)-'a']--;
                    j++;
                }
                lcs++;
                subsequence += y.charAt(i);
                j++;
            }
        }
        System.out.println("Improved Greedy: subsequence = " + subsequence + ", LCS = " + lcs);

    }
    private static void FullSearchLCS(String x, String y) {
        int[] x_array = new int[x.length()];
        int[] y_array = new int[y.length()];
        String x_subsequence = "";
        String y_subsequence = "";
        int x_size = (int)Math.pow(2, x.length())-1;
        int y_size = (int)Math.pow(2, y.length())-1;
        int lcs = 0;

        String max_subsequence = "";

        for (int i = 0; i < x_size; i++) {
            Plus1(x_array);
            x_subsequence = ConvertArrayToSubsequence(x, x_array);
            ClearY_Array(y_array);
            for (int j = 0; j < y_size; j++) {
                Plus1(y_array);
                y_subsequence = ConvertArrayToSubsequence(y, y_array);
                if (x_subsequence.equals(y_subsequence))
                {
                    if (x_subsequence.length() > lcs)
                    {
                        lcs = x_subsequence.length();
                        max_subsequence = x_subsequence;
                        break;
                    }
                }
            }
        }
        System.out.println("Full Search:\t subsequence = " + max_subsequence + ", LCS = " + lcs);
    }

    private static void Plus1(int[] y_array) {
        boolean flag = true;
        int i = y_array.length-1;
        while(flag == true)
        {
            if (y_array[i] == 0)
            {
                y_array[i] = 1;
                flag = false;
            }
            else
            {
                y_array[i] = 0;
                i--;
            }
        }
    }
    private static String ConvertArrayToSubsequence(String y, int[] y_array) {
        String ans = "";
        for (int i = 0; i < y_array.length; i++) {
            if (y_array[i] == 1)
                ans += y.charAt(i);
        }
        return ans;
    }
    private static void ClearY_Array(int[] y_array) {
        for (int i = 0; i < y_array.length; i++) {
            y_array[i] = 0;
        }
    }

}
