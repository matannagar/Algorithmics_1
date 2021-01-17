package median_num;

import java.util.Arrays;

public class median_num {
    public static void main(String[] args) {
        int[] arr1 = {10, 4, 13, 8, 3, 88, 5, 15, 22, 41, 1, 56, 32};
        int[] arr2 = {78, 67, 103, 81, 33, 828, 51, 13, 20, 48, 1, 4, 99};
        Arrays.sort(arr1);
        System.out.println(Arrays.toString(arr1));
        Arrays.sort(arr2);
        System.out.println(Arrays.toString(arr2));

//        System.out.println(MAX(arr1));
        System.out.println(Arrays.toString(all_elements_greater_than_median(arr1, arr2)));
    }

    /**
     *     probabilty of being wrong after 64 check is 1/2^k (k is num of elements)
     *     the more elements in the array, the less probability of being wrong
     */
    public static int median64(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < 64; i++) { // ראשונים איברים 46 מתוך הגדול האיבר מציאת
            if (arr[i] > max) max = arr[i];
        }
        return max;
    }

    /**
     * return one element in the array that bigger than median
     * Complexity: O(check)
     */
    public static int getBiggerThanMedian(int[] arr, int check) {
        int max = arr[0];
        for (int i = 1; i < check; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }

    /**
     * checks the probability to make a mistake if we checking check elements in the array with arr_size
     */
    public static double getMistakeProb(int arr_size, int check, int count) {
        int incorrect = 0;

        int[] arr = new int[arr_size];
        for (int i = 0; i < count; i++) {
            //creates an array with random numbers
            for (int j = 0; j < arr.length; j++) {
                arr[j] = (int) (Math.random() * count * 10);
            }
            //recursive calls
            int x = getBiggerThanMedian(arr, check);
            Arrays.sort(arr);
            if (x < arr[arr.length / 2]) incorrect++;
        }
        return (double) incorrect / count;
    }

    public static int MAX(int[] arr) {
        int max = arr[0];

        for (int i = 1; i < arr.length - 1 && i < 64 - 1; i += 2) {
            if (arr[i] > arr[i + 1]) {
                if (max < arr[i])
                    max = arr[i];
            } else {
                if (max < arr[i + 1])
                    max = arr[i + 1];
            }
        }
        return max;
    }

    public static int[] all_elements_greater_than_median(int[] a, int[] b) {
        int n = a.length;
        int[] c = new int[n];

        for (int i = 0; i < n; i++) {
            c[i] = Math.max(b[n - 1 - i], a[i]);
        }
        return c;
    }
}
