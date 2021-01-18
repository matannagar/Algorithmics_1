package tests;

public class cycle_LIS {
    public static void main(String[] args) {
//page 52 - circle problem
    }

//    public static int[] LIS_cycle(int[] arr) {
//        int max = 0;
//        int index = 0;
//        for (int i = 0; i < arr.length; i++) {
//
//        }
//    }

    /**
     * return the longest increasing sequence of numbers
     */
    public static int LIS_length(int[] arr) {
        int[][] mat = new int[arr.length][arr.length];
        mat[0][0] = arr[0];//place the first element of the diagonal
        int lis_length =1; //at least 1
        //loop through the int array
        for (int i = 0; i < arr.length; i++) {
            //binary_search the diagonal to return index to insert new item
        int index = binarySearchDiag(mat, lis_length,arr[i]);
        mat[index][index] = arr[i]; //place the element on the diagonal
            if(index==lis_length) lis_length++;
        }
        return lis_length;
    }
    public  static int binarySearchDiag(int[][] mat, int index, int element){
        if (element> mat[index-1][index-1]) return index;
        if( element < mat[0][0]) return 0; // you are smaller than the smallest element, return 0 to the beginning

        //the actual binary search
        int end = index, start = 0;
        // find where to insert new element
        // not smaller than [0][0]
        // not bigger than the last element
        while (start<=end){
            if (start==end) return start; // no more elements
            //split the array in the middle
            int mid = (start+end) /2 ;
            if(mat[mid][mid]== element) return mid; // equal to mat[mid]
            if(mat[mid][mid]> element) end= mid; // start = 0 , end = mid;
            else start = mid+1;
        }
        return -1;
    }
    public static int[] LISDynamic(int[] arr) {
        int n = arr.length;
        int[][] mat = new int[n][n];
        mat[0][0] = arr[0];
        int len = 1;
        for (int i = 1; i < n; i++) {
            int index = binarySearchDiag(mat, len, arr[i]);
            mat[index][index] = arr[i];
            if (index == len) len++;
            for (int k = 0; k < index; k++) {
                mat[index][k] = mat[index-1][k];
            }
        }

        int[] ans = new int[len];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = mat[len - 1][i];
        }
        return ans;
    }
}
