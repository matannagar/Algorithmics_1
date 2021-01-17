package Prisoners;

public class prisoners_problem {
    public static void main(String[] args) {
        prisonProblemUnknownState();
        System.out.println("--------");
        prisonProblem();
    }

        private static final int NumOfPrisoners = 10; // 0...9
        private static final int counterMan = 0; // is responsible for the count

        /**
         * prison problem when the initial state of light is known (on)
         * Complexity: O(?)
         */
        public static void prisonProblem() {

            boolean light = true; //set bulb to on
            boolean firstTime = true; //will mark if the counter was already in
            boolean[] enter = new boolean[NumOfPrisoners];//array of n prisoners to mark if they visited or not
            int count = 0; // count how many prisoners were inside (counters job)
            int steps = 0; // number of moves until all prisoners went inside
            while(count < NumOfPrisoners) {
                steps++;
                int turnToEnter = (int)(Math.random()*NumOfPrisoners); // choose random prisoner to enter
                if(turnToEnter == counterMan) {
                    if(firstTime) {
                        enter[counterMan] = true; //update bool array that prisoner visited the room
                        count++; // a prisoner was inside
                        firstTime = false;
                    }
                    if(!light) {
                        light = true; // if light was turned off, the counter will turn it on
                        count++; // and count an additional prisoner (only prisoners first time will turn on the light)
                    }
                }
                else {
                    if(light && !enter[turnToEnter]) { // if light is turned on and this is the prisoners first time in the room
                        light = false; // he will turn off the light
                        enter[turnToEnter] = true; // mark that he visited the room
                    }
                }
            }
            for (int i = 0; i < enter.length; i++) { //check that all prisoners went in the room
                if(!enter[i]) {
                    System.out.println("Fail!");
                    return;
                }
            }
            System.out.println("We are free!");
            System.out.println("Number of steps = " + steps);
        }

        /**
         * prison problem when the initial state of light is Unknown
         */
        public static void prisonProblemUnknownState() {
            boolean light = (int) (Math.random() * 2) != 0; //random lightbulb on or off
            boolean firstTime = true; // tells if the counter was inside the room or not
            int[] enter = new int[NumOfPrisoners]; //visited array
            int count = 0; // how many were in
            int steps = 0; // num of moves
            while(count < 2*NumOfPrisoners) {
                steps++;
                int turnToEnter = (int)(Math.random()*NumOfPrisoners); // which prisoner will go in
                if(turnToEnter == counterMan) { //if it was the counter
                    enter[counterMan]++; // 1 equals true
                    if(firstTime) {
                        count+=2;
                        firstTime = false;
                    }
                    if(light) {
                        light = false;
                        count++;
                    }
                }
                else {
                    if(!light && enter[turnToEnter] <2) {
                        light = true;
                        enter[turnToEnter]++;
                    }
                }
            }
            for (int j : enter) {
                if (j == 0) {
                    System.out.println("Fail!");
                    return;
                }
            }
            System.out.println("We are free!");
            System.out.println("Number of steps = " + steps);
        }

    }
