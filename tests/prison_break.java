package tests;

public class prison_break {
    public static void main(String[] args) {
        light_is_on(10);
        light_unknown(10);
    }

    public static void light_is_on(int tot_prisoners) {
        boolean light = true;
        boolean[] enter = new boolean[tot_prisoners];
        int count = 0;
        boolean count_entered = false;

        while (count < tot_prisoners) {
            int prisoner = (int) (Math.random() * tot_prisoners);
            if (prisoner == 0) {
                if (!count_entered) {
                    count++;
                    count_entered = true;
                    enter[prisoner] = true;
                }
                if (!light) {
                    light = true;
                    count++;
                }
            } else {
                if (light && !enter[prisoner]) {
                    light = false;
                    enter[prisoner] = true;
                }
            }
        }
        for (int i = 0; i < enter.length; i++) {
            if (!enter[i]) System.out.println("error!");
        }
    }


    public static void light_unknown(int tot_prisoners) {
        boolean light = (int) (Math.random() * 1) != 0; // choose random on or off
        boolean count_visit = false; // set false for the first time the counter visited
        int count = 0; // count how many were in the room
        int[] visited = new int[tot_prisoners]; // everytime you enter the room, add 1


        while (count < 2 * tot_prisoners) {//count should be at least two times the num of prisoner because there is a double check
            int prisoner = (int) (Math.random() * tot_prisoners); //choose random prisoner
            if (prisoner == 0) { //if prisoner is the counter
                visited[0]++; // add to visited array
                if (!count_visit) { // if this is the first he entered the room
                    count_visit = true; // mark as visited
                    count = count + 2; // add to counter two time because he is sure to visit
                }
                if (light) { // in case the light was on , it means someone was in (perhaps)
                    light = false; //turn it off.
                    count++;// add to count cus someone turned it on
                }
            } else { // if i am a regular prisoner
                if (!light && visited[prisoner] < 2) { // if i didnt enter the room enough time and the light is off
                    light = true; // it means the counter turned it off and i need to turn it on
                    visited[prisoner]++; // mark as visited ++
                }
            }
        }
        for (int check : visited) {
            if (check == 0) {
                System.out.println("error!");
                return;
            }
        }
        System.out.println("all were freed");
    }
}
