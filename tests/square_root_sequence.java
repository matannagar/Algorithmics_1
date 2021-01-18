package tests;

import java.util.ArrayList;
import java.util.Arrays;

public class square_root_sequence {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 3, 9, 2, 4, 16, 8, 81, 64};
//                   0  1  2  3  4  5  6  7
        System.out.println(return_root_square_sequence(arr));
    }

    public static ArrayList<Integer> return_root_square_sequence(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        int[] tray = new int[arr.length];
        Arrays.fill(tray, 1);
        int max = 0;
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j] * arr[j] || arr[i] == Math.sqrt(arr[j])) {
                    tray[j] = tray[i] + 1;
                }
            }
        }
        for (int i = 0; i < tray.length; i++) {
            if (max < tray[i]) {
                max = tray[i];
                index = i;
            }
        }
        list.add(index);
        int i = index;
        int j = i-1;
        while (j>=0){
            if (tray[i]-1 == tray[j]){
                if ( Math.sqrt(arr[i])==arr[j] ||arr[j]==arr[i]*arr[i] ){
                    list.add(j);
                    i=j;
                }
            }
            j--;
        }
        return list;
    }
}
