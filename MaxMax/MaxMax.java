package MaxMax;

import java.util.Arrays;
import java.util.Stack;

/**
 * Three algorithms search for 2 largest elements of an array.
 * Each function returns the number of comparisons
 * A={arr[0], arr[1], . . . ,arr[arr.length]}
 * max1 = maximum{A}
 * max2 = maximum{A\max1}
 * Remark: the start values of max1, max2 must be different.
 * Assumptions:
 * 1)elements of the array are different
 * 2) array length > 2
 **/
public class MaxMax {
    public static void main(String[] args) {
        int[] arr = {10,7,11,2,5,0,6,3,1,12,17};
        int_to_node(arr);
    }

    static class Node {
        int num;
        Stack<Integer> stack;

        public Node(int num) {
            this.num = num;
            stack = new Stack<>();
        }
    }
    /* + first time : the function gets the entire node_array and then begins splitting it to ones
    {10,11,5,14}
    {10,11} {5,14}
    {10}{11}{5}{14}
     */
    public static int recursiveMax(Node[] arr, int low, int high) {
        int index ;

        if (low < high) {
            int middle = (low + high) / 2;
            int i = recursiveMax(arr, low, middle);
            int j = recursiveMax(arr, middle + 1, high);

            if (arr[i].num > arr[j].num) {
                arr[i].stack.push(arr[j].num);
                index = i;
            } else {
                arr[j].stack.push(arr[i].num);
                index = j;
            }
            return index;
        }
        else return low;
    }

    // + function converts int array to node array
    public static void int_to_node(int[] arr) {
        Node[] node_arr = new Node[arr.length];
        // + create a node for each integer
        for (int i = 0; i < arr.length ; i++)
            node_arr[i] = new Node(arr[i]);

        // + send the entire node array to the function
        int index = recursiveMax(node_arr, 0, arr.length - 1);
        int max2 = node_arr[index].stack.pop();

        while (!node_arr[index].stack.isEmpty()) {
            int temp = node_arr[index].stack.pop();
            if (temp > max2)
                max2 = temp;
        }
        System.out.println(arr[index] + " " + max2);
    }
}
