package tests;

import java.util.ArrayList;
import java.util.Arrays;

public class longest_increase_decrease_sequence {
    public static void main(String[] args) {
        int[] arr = {3,2,7,8,9,1,5,0,6,-1};
        System.out.println(longest_LIS_LDS(arr));
    }

    public static int longest_LIS_LDS(int[] arr){
        int max_length = Math.max(LIS(arr),LDS(arr));
        for (int i = 1; i < arr.length; i++) {
                int[] firstHalf = Arrays.copyOfRange(arr, 0, i);
                int first = LIS(firstHalf);
                int[] secondHalf = Arrays.copyOfRange(arr, i+1, arr.length);
                int second = LDS(secondHalf);
                int sum = second + first;
                if (sum>max_length){
                   max_length= sum;
                }
        }
        return max_length;
    }

    public static int LIS(int[] arr) {
        int n = arr.length;
        //matrix n*n
        int[][] mat = new int[n][n];
        //first element of array and matrix is the same
        mat[0][0] = arr[0];
        //size of
        int lis = 1;
        //loop through the int array
        for (int i = 1; i < n; i++) {
            //binary_search the diagonal to return index to insert new item
            int index = binarySearchBetween(mat, lis, arr[i]);
            mat[index][index] = arr[i];
            if (index == lis) lis++;
        }
        return lis;
    }

    private static int binarySearchBetween(int[][] mat, int curr_index, int element) {
        //if this element is bigger than the last one then return the same index (lis)
        if (element > mat[curr_index - 1][curr_index - 1])
            return curr_index;
        //replace the first element
        if (element < mat[0][0])
            return 0;


        int high = curr_index, low = 0;
        // find where to insert new element
        // not smaller than [0][0]
        // not bigger than the last element
        while (low <= high) {
            if (low == high)
                return low;
            int mid = (low + high) / 2;
            if (mat[mid][mid] == element)
                return mid;
            if (mat[mid][mid] > element)
                high = mid;
            else low = mid + 1;
        }

        return -1;
    }
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
//        System.out.println(" LDS length is : " + index);
//        System.out.println(list);
        return max;
    }
}


