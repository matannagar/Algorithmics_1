package LIS;

import java.util.Arrays;

public class LIS {
    /**
     * dynamic programming of LIS - get the length only (can be done with array instead of matrix)
     * Complexity: O(n*log n)
     */
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
        printMatrix(mat);
        return lis;
    }

    /**
     * dynamic programming of LIS - get the sequence
     * Complexity: O(n^2)
     */
    public static int[] LISDynamic(int[] arr) {
        int n = arr.length;
        int[][] mat = new int[n][n];
        mat[0][0] = arr[0];
        int len = 1;
        for (int i = 1; i < n; i++) {
            int index = binarySearchBetween(mat, len, arr[i]);
            mat[index][index] = arr[i];
            if (index == len) len++;
            copy(mat, index);
            printMatrix(mat);
        }

        int[] ans = new int[len];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = mat[len - 1][i];
        }
        return ans;
    }

    /**
     *     completes the elements up to the diagonal element
     *     1* 0 0 0 0 0 0 0
     *     1 2* 0 0 0 0 0 0
     *     1 2 3* 0 0 0 0 0
     *     1 2 3 4* 0 0 0 0
     *     1 2 3 4 5* 0 0 0
     */
    private static void copy(int[][] mat, int index) {
        for (int i = 0; i < index; i++) {
            mat[index][i] = mat[index-1][i];
        }
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
//
    public static void printMatrix(int[][] mat) {
        for (int[] ints : mat) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println((Arrays.toString(LISDynamic(new int[]{5,9,4,20,6,3,7,8,11}))));//,2,100,101,3,4,5})));
//        System.out.println(LISDynamic(new int[]{1, 2,100,101,3,4,5}).length);//,2,100,101,3,4,5})));
//        System.out.println(LISDynamicLen(new int[]{1, 2, 100, 101, 3, 4, 5}));//,2,100,101,3,4,5})));
    }
}
