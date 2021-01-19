package tests;

import java.util.Arrays;

public class LIS_max_value {
    public static void main(String[] args) {
        int[] arr = {10,7,5,4,3,4,1,2,4,7};
        System.out.println(max_value_LIS(arr,3));
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
                }
            }
        }
        return max;
    }
}
