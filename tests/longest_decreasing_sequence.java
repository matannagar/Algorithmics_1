package tests;

import java.util.ArrayList;
import java.util.Arrays;

public class longest_decreasing_sequence {
    public static void main(String[] args) {
        int[] arr = {3, 6, 7, 1, 4, 12, 2,1};
        System.out.println(LDS(arr));
    }

    /**
     * returns length of longest decreasing subsequence
     * and also prints it
     */
    public static int LDS(int[] arr) {
        int[] tray = new int[arr.length]; //blank array
        int max = 0; // initilize index and ans

        // element is always 1 because the shortest ans has to be 1
        for (int i = 0; i < arr.length; i++)
            tray[i] = 1;

        // Compute LDS from every index
        // in bottom up manner
        for (int i = 1; i < arr.length; i++)
            for (int j = 0; j < i; j++)
                if (arr[i] < arr[j] && tray[i] < tray[j] + 1)
                    tray[i] = tray[j] + 1;

        // Select the maximum
        // of all the LDS values
        int index = 0; // saves the index of start of LDS
        for (int i = 0; i < arr.length; i++) {
            if (max < tray[i])
                max = tray[i];
            index = i;
        }
        int i = index;
        int j = index - 1;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(index);
        while (j >= 0) {
            if (tray[i] - 1 == tray[j]) {
                if (arr[j] > arr[i]) {
                    list.add(j);
                    i = j;
                }
            }
            j--;
        }
        // returns the length of the LDS
        System.out.println(" LDS length is : " + index);
        System.out.println(list);
        return max;
    }
}


