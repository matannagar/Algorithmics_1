package minMax;

// Or Kadrawi
public class minMax {

    public static void main(String[] args) {

        //create array
        int[] arr = GenerateArray(100);

        //find minmax - algorithm5
        MinMax5(arr);

        //calculate compares for algorithm3
        Simulation();
    }

    private static int[] GenerateArray(int n) {
        //creates an array with n different variables
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 1000);
        }
        return arr;
    }

    private static void MinMax5(int[] arr) { // 3n/2 - 2
        int min = arr[0], max = arr[1];

        if (arr[0] > arr[1]) {
            max = arr[0];
            min = arr[1];
        }
        for (int i = 2; i < arr.length - 1; i = i + 2) {
            if (arr[i] < arr[i + 1]) {
                if (arr[i] < min)
                    min = arr[i];
                if (arr[i + 1] > max)
                    max = arr[i + 1];
            } else {
                if (arr[i] > max)
                    max = arr[i];
                if (arr[i + 1] < min)
                    min = arr[i + 1];
            }
        }
        if (arr.length % 2 == 1) {
            int last = arr[arr.length - 1];
            if (last < min)
                min = last;
            else if (last > max)
                max = last;
        }
        System.out.println("Min = " + min);
        System.out.println("Max = " + max);


    }

    private static void Simulation() {
        int numOfTests = 1000;
        int[] arr;
        int min, max;
        int counter = 0;


        for (int j = 0; j < numOfTests; j++) {

            arr = GenerateArray(1000);
            min = max = arr[0];
            for (int i = 1; i < arr.length; i++) {
                counter++;
                if (arr[i] < min)
                    min = arr[i];
                else {
                    counter++;
                    if (arr[i] > max)
                        max = arr[i];
                }
            }
        }
        System.out.println("Average Counter = " + counter / numOfTests);

    }

}
