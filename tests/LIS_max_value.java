package tests;

import java.util.Arrays;

public class LIS_max_value {
    public static void main(String[] args) {
        int[] arr = {10,7,5,4,3,4,1,2,4,7};
        System.out.println(max_value_LIS(arr,3));
    }

    public static int[] LISDynamic(int[] arr) {
        int n = arr.length;
        int[][] mat = new int[n][n];
        mat[0][0] = arr[0];
        int len = 1;
        for (int i = 1; i < n; i++) {
            int index = binarySearchBetween(mat, len, arr[i]);
            mat[index][index] = arr[i];
            if (index == len) len++;
            //copies the line from above
            for (int k = 0; k < index; k++) {
                mat[index][k] = mat[index - 1][k];
            }
        }
        //create the answer from the last line of the matrix
        int[] ans = new int[len];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = mat[len - 1][i];
        }
        return ans;
    }

    public static int binarySearchBetween(int[][] mat, int curr_index, int element) {
        if (element > mat[curr_index - 1][curr_index - 1]) return curr_index;
        if (element < mat[0][0]) return 0; //be placed at the start

        int high = curr_index, start = 0;
        while (high >= start) {
            if (start == high) return start;
            int mid = (start + high) / 2;
            if (mat[mid][mid] == element)
                return mid;
            if (mat[mid][mid] > element)
                high = mid;
            else start = mid + 1;
        }
        return -1;
    }

    public static int LISDynamicLen(int[] arr) {
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

    public static int max_value_LIS(int[] arr, int k) {
        int[] ans = new int[arr.length];
        Arrays.fill(ans, 1); //fill array with 1;
        int max = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] - arr[j] == k || arr[i] - arr[j] == (-1) * k) {
                    if (ans[j] + 1>ans[i])
                    ans[i] = ans[j] + 1;
                }
                if (ans[i] > max) {
                    max = ans[i];
                    System.out.println(i +" ->" + max);
                }
            }
        }
        System.out.println(Arrays.toString(ans));
        return max;
    }
}
