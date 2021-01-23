package egg_drop;

public class two_eggs_triangle {
    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i;
        }
        int random = (int)(Math.random()*100);
//        int random = 39;
        System.out.println("break floor is : "+ random);
        useFloorPotential(random,arr);
    }

    public static void useFloorPotential(int breakFloor, int[] arr) {
        int p = 1; //num of attempts
        int numFloors = arr.length;

        while (numFloors > p * (p + 1) / 2) p++; //set first try to (p*(p+1))/2

        int jump = p;//jump will be the first floor from which the egg was broken
        int step = p - 1; // if egg was not broken, step up a floor

        while (arr[jump] < breakFloor) { // the egg is not breaking
            jump += step;
            step --;
        }
        System.out.println("the first ball breaks at floor " + jump);

        int before_break = jump - (step + 1); //last floor before egg broke
        while (arr[before_break] < breakFloor) { // climb up and throw the egg until it breaks
            before_break++;
        }
        System.out.println("the second ball is broken at floor number " + before_break);
    }
}
