package Donuts;

public class Donuts {
    private static final int time = 2;

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println("num of dounuts:" +i);
            System.out.println(getTime(i,5));
        }
    }

    /**
     * returns the total time for the daunts
     * Complexity: O(1)
     */
    public static int getTime(int numOfDonuts, int capacity) {
        if (capacity >= numOfDonuts) return time;
        if ((time * numOfDonuts) % capacity == 0) return (time * numOfDonuts) / capacity;
        return (time * numOfDonuts) / capacity + 1;
    }
}
