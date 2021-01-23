package twenty_five_horses;

import java.util.Arrays;

public class horses {
    public static void main(String[] args) {
        int[] arr = {15,11,12,3,5,6,77,2,31,34,35,56,78,90,65,43,22,19,47,48,88,77,66,55,33};
        System.out.println(arr.length);
        find_3_max(arr);
    }
    public static void find_3_max(int[] arr) {
        int[] arr1 = new int[5];
        int[] arr2 = new int[5];
        int[] arr3 = new int[5];
        int[] arr4 = new int[5];
        int[] arr5 = new int[5];
        for (int i = 0; i < 5; i++) {
            arr1[i] = arr[i];
            arr2[i] = arr[i + 5];
            arr3[i] = arr[i + 10];
            arr4[i] = arr[i + 15];
            arr5[i] = arr[i + 20];
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        Arrays.sort(arr3);
        Arrays.sort(arr4);
        Arrays.sort(arr5);
        System.out.println("5 races!");

        System.out.println("winner from race 1 is :"+arr1[4]);
        System.out.println("winner from race 2 is :"+arr2[4]);
        System.out.println("winner from race 3 is :"+arr3[4]);
        System.out.println("winner from race 4 is :"+arr4[4]);
        System.out.println("winner from race 5 is :"+arr5[4]);

        int[] contest = {arr1[4],arr2[4],arr3[4],arr4[4],arr5[4]};
        Arrays.sort(contest);
        System.out.println("6 race!");
        System.out.println("Top winners are: "+ contest[4]+" --> " + contest[3] +" --> "+ contest[2]);
    }
}