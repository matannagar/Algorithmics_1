package turtle_rabbit;

import java.util.Arrays;


public class turtle_rabbit_arm {
    public static void main(String[] args) {
        myLinkedList spear = new myLinkedList();
        for (int i = 0; i < 5; i++) {
            spear.add(i + 10);
        }
        LinkedListCycle circle = new LinkedListCycle();
        for (int i = 0; i < 10; i++) {
            circle.add(i);
        }
        spear.addNode(circle.getHead());
        System.out.println(Arrays.toString(arm_cycle(spear)));
    }

    public static int[] arm_cycle(myLinkedList spear) {
        int[] answer = new int[3];
        boolean flag = true;
        boolean toRun = true;
        int ans = -1;
        int cycle = 1;

        // * pointer to the first node
        Node rabbit = spear.getHead();
        Node turtle = spear.getHead();


        while (flag) {
            // * if one of the nodes is null then this is not a cycle
            if (turtle.getNext() == null || rabbit.getNext() == null || rabbit.getNext().getNext() == null) {
                System.out.println("There is no cycle");
                flag = false;
                toRun = false;
            } else {
                // * move forward
                turtle = turtle.getNext();
                rabbit = rabbit.getNext().getNext();


                if (turtle.getData() == rabbit.getData()) {
                    System.out.println("Is a cycle!");
                    flag = false;
                    toRun = true;
                }
            }
        }
        // * put rabbit at the beginning of the spear and turtle remains at meeting point
        rabbit = spear.getHead();
        while (toRun) {
            ans++;
            if (turtle.getData() == rabbit.getData()) {
                toRun = false;
            } else {
                turtle = turtle.getNext();
                rabbit = rabbit.getNext();
            }
        }
        turtle = turtle.getNext();
        while (turtle.getData() != rabbit.getData()) {
            turtle = turtle.getNext();
            cycle++;
        }
        answer[0] = ans;
        answer[1] = cycle;
        answer[2] = turtle.getData();
        return answer;
    }
}
