package turtle_rabbit;

public class turtle_rabbit {
    public static void main(String[] args) {

        LinkedListCycle circle = new LinkedListCycle();
        for (int i = 0; i < 10; i++) {
            circle.add((char) i);
        }
        System.out.println(isCycle(circle));
    }

    public static boolean isCycle(LinkedListCycle circle) {
        boolean flag = true;
        boolean ans = true;
        int count = 0;

        // * pointer to the first node
        Node rabbit = circle.getHead();
        Node turtle = circle.getHead();

        while (flag) {
            count++;
            // * if one of the nodes is null then this is not a cycle
            if (turtle.getNext() == null || rabbit.getNext() == null || rabbit.getNext().getNext() == null) {
                System.out.println("There is no cycle");
                flag = false;
                ans = false;
            } else {
                turtle = turtle.getNext();
                rabbit = rabbit.getNext().getNext();

                if (turtle.getData() == rabbit.getData()) {
                    System.out.println("Is a cycle!");
                    flag = false;
                    ans = true;
                }

            }
        }
        return ans;
    }
}
