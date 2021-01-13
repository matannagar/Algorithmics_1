package parkingLot;

import parkingLot.Node;
import parkingLot.LinkedListCycle;


public class parkingLot {
    public static void main(String[] args) {
        LinkedListCycle parking = new LinkedListCycle();
        int nLetters = 23, size = 13;
        char v = 'v', w = 'w';

        for (int i = 0; i < size; i++) {
            char c = (char) ('a' + (int) (Math.random() * nLetters));
            parking.add(c);
        }
        System.out.println(parking.toString());
        System.out.println(parking.getSize());
        System.out.println("num of cars with 1 pointer:" + countCars(parking, v, w));
        System.out.println("num of cars with 2 pointer:" + parkingPointers(parking));
    }


    public static int countCars(LinkedListCycle parking, char v, char w) {
        parking.getHead().setData(v); // we'll mark the first car with V
        Node t = parking.getHead().getNext(); // move the pointer one car to the left
        boolean flag = true;
        int count = 1; // count number of steps (counted the head car)
        while (flag) {
            if (t.getData() == v) { //if we encounter a car marked with V
                t.setData(w); //well mark it W
                int i = count;
                while (i > 0) {
                    t = t.getPrev(); //and go back count steps
                    i--;
                }
                if (t.getData() == w) // we'll check if this was the only V marked car
                    flag = false; // if so, we are done and can return count;
                else { //if not, we need to mark more cars with W
                    count = 1;
                    t = parking.getHead().getNext(); //start walking again
                }
            } else { //if this car is not marked with V or W, keep stepping forward
                t = t.getNext();
                count++;
            }
        }
        return count;
    }

    //using two pointers is O(n) complexity
    public static int parkingPointers(LinkedListCycle parking) {
        int result = 1; // counter
        Node forward = parking.getHead().getNext(); // set the pointer to a car next to the first car
        Node head = parking.getHead(); // well loop through the cycle

        while (forward != head) {
            forward = forward.getNext();
            result++; // counter ++
        }
        return result;
    }
}




