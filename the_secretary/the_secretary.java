package the_secretary;

import java.util.Arrays;

public class the_secretary {
 public static void main(String[] args) {
     int[] arr = generateArr(19);
     System.out.println(Arrays.toString(generateArr(15)));
     System.out.println(getAvarage(arr));
}
    public static double getAvarage(int[] times) {
        Arrays.sort(times);
        double avg = 0;
        for (int x : times)
            avg = avg + x;

        return avg / times.length;
    }

    public static int[] generateArr(int n) {
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = (int) (Math.random() * 100);
        }
        return arr;
    }
}
