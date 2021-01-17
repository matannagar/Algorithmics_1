package compiler_problem;

public class compiler_problem {
    public static void main(String[] args) {
        Program p1 = new Program("a1",6,6);
        Program p2 = new Program("a2",9,5);
        Program p3 = new Program("a3",2,14);
        Program p4 = new Program("a4",3,13);
        Program p5 = new Program("a5",11,10);

        Program[] arr= new Program[5];
        arr[0] = p1;
        arr[1] = p2;
        arr[2] = p3;
        arr[3] = p4;
        arr[4] = p5;

        getOptimalOrder(arr);
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
        mergeSort(programs, 0, programs.length);
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
        mergeSort(programs, mid+1, high);

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
}
