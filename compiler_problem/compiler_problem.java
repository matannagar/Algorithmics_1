package compiler_problem;

import java.util.Arrays;

public class compiler_problem {
    public static void main(String[] args) {
        Program p1 = new Program("a1", 3, 12);
        Program p2 = new Program("a2", 3, 3);
        Program p3 = new Program("a3", 3, 4);
        Program p4 = new Program("a4", 3, 3);
        Program p5 = new Program("a5", 3, 6);

        Program[] arr = new Program[5];
        arr[0] = p1;
        arr[1] = p2;
        arr[2] = p3;
        arr[3] = p4;
        arr[4] = p5;
        getOptimalOrder(arr);

        Arrays.sort(arr,(o1, o2) -> o1.freq/o1.len);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * create a program class with variables of length
     * and probability of use (frequency)
     */
    static class Program {
        String name;
        int len, freq;

        public Program(String name, int len, int freq) {
            this.name = name;
            this.len = len;
            this.freq = freq;
        }

        @Override
        public String toString() {
            return "[" + name + " ," + len + " ," + freq + "]";
        }
    }

    public static void getOptimalOrder(Program[] programs) {
        sort_when_len_is_equal(programs, 0, programs.length);
        int totalTime = 0;
        int totalLen = 0;
        for (Program program : programs) {
            System.out.println(program);
            totalTime += (totalLen + program.len) * program.freq;
            totalLen += program.len;
        }
        System.out.println("Total time: " + totalTime);
    }

    private static void mergeSort(Program[] programs, int low, int high) {
        int n = high - low;
        if (n <= 1) return;

        int mid = (low + high) / 2;
        mergeSort(programs, low, mid);
        mergeSort(programs, mid, high);

        int i = low, j = mid, k = 0;

        Program[] temp = new Program[n];
        while (i < mid && j < high) {
            double t1 = (double) programs[i].len / programs[i].freq;
            double t2 = (double) programs[j].len / programs[j].freq;
            if (t1 < t2) temp[k++] = programs[i++];
            else temp[k++] = programs[j++];
        }
        while (i < mid) temp[k++] = programs[i++];
        while (j < high) temp[k++] = programs[j++];

        System.arraycopy(temp, 0, programs, low, n);
    }

    private static void sort_when_freq_is_equal(Program[] programs, int low, int high) {
        int n = high - low;
        if (n <= 1) return;

        int mid = (low + high) / 2;
        sort_when_freq_is_equal(programs, low, mid);
        sort_when_freq_is_equal(programs, mid, high);

        int i = low, j = mid, k = 0;

        Program[] temp = new Program[n];
        while (i < mid && j < high) {
            double t1 =  programs[i].len;
            double t2 =  programs[j].len;
            if (t1 < t2) temp[k++] = programs[i++];
            else temp[k++] = programs[j++];
        }
        while (i < mid) temp[k++] = programs[i++];
        while (j < high) temp[k++] = programs[j++];

        System.arraycopy(temp, 0, programs, low, n);
    }

    private static void sort_when_len_is_equal(Program[] programs, int low, int high) {
        int n = high - low;
        if (n <= 1) return;

        int mid = (low + high) / 2;
        sort_when_len_is_equal(programs, low, mid);
        sort_when_len_is_equal(programs, mid, high);

        int i = low, j = mid, k = 0;

        Program[] temp = new Program[n];
        while (i < mid && j < high) {
            double t1 =  programs[i].freq;
            double t2 =  programs[j].freq;
            if (t1 < t2) temp[k++] = programs[i++];
            else temp[k++] = programs[j++];
        }
        while (i < mid) temp[k++] = programs[i++];
        while (j < high) temp[k++] = programs[j++];

        System.arraycopy(temp, 0, programs, low, n);
    }
}

