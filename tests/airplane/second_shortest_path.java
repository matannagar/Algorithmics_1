package tests.airplane;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class second_shortest_path {
    public static void main(String[] args) {
        Node[][] mat = InitMat1();
        System.out.println(second_cheapest_path(mat));
    }

    static class Node {
        int x, y, price, price_2, entryFromTheEnd;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
            price = 0;
            price_2 =0;
            entryFromTheEnd = 0;
        }

        @Override
        public String toString() {
            return ""+ price;
        }
    }
    private static int second_cheapest_path(Node[][] mat) {
        int column = mat.length, row = mat[0].length;
        //set prices for first column
        for (int i = 1; i < column; i++) {
            mat[i][0].price = mat[i - 1][0].y + mat[i - 1][0].price;
            mat[i][0].price_2 =mat[i][0].price;
        }
        //set prices for first row
        for (int j = 1; j < row; j++) {
            mat[0][j].price = mat[0][j - 1].price + mat[0][j - 1].x;
            mat[0][j].price_2 =mat[0][j].price;
        }
        //set prices for the rest of the nodes
        for (int i = 1; i < column; i++) {
            for (int j = 1; j < row; j++) {
                int y = mat[i - 1][j].price + mat[i - 1][j].y;//calculates the value of node + y_price
                int y_1 = mat[i - 1][j].price_2 + mat[i - 1][j].y;//calculates the value of node + y_price
                int x = mat[i][j - 1].price + mat[i][j - 1].x;//calculates the value of node + x_price
                int x_1 = mat[i][j - 1].price_2 + mat[i][j - 1].x;//calculates the value of node + x_price
                System.out.println("option 1: "+y+" option2: "+y_1+" option3: "+x+" option4:"+x_1);
                Point min1_min2 = get_min1_min2(y,y_1,x,x_1);
                mat[i][j].price = min1_min2.x; //sets which one is better
                mat[i][j].price_2 = min1_min2.y; //sets which one is better
                System.out.println(" chose best: "+min1_min2.x +" second: "+ min1_min2.y);
            }
        }
        Print(mat);
        return mat[column - 1][row - 1].price_2;
    }
    public static Point get_min1_min2(int a, int b, int c, int d){
        if (a==b && c==d) return new Point(Math.min(a,c),Math.max(a,c));
        int[] arr = {a,b,c,d};
        Arrays.sort(arr);
        return (new Point(arr[0],arr[1]));
    }
    private static Node[][] InitMat1() {
        Node[][] mat = new Node[4][5];

        mat[0][0] = new Node(8, 1);
        mat[0][1] = new Node(8, 8);
        mat[0][2] = new Node(8, 8);
        mat[0][3] = new Node(8, 9);
        mat[0][4] = new Node(0, 8);

        mat[1][0] = new Node(1, 1);
        mat[1][1] = new Node(8, 1);
        mat[1][2] = new Node(8, 8);
        mat[1][3] = new Node(8, 8);
        mat[1][4] = new Node(0, 8);

        mat[2][0] = new Node(8, 1);
        mat[2][1] = new Node(1, 8);
        mat[2][2] = new Node(1, 8);
        mat[2][3] = new Node(8, 0);
        mat[2][4] = new Node(0, 8);

        mat[3][0] = new Node(1, 0);
        mat[3][1] = new Node(2, 0);
        mat[3][2] = new Node(0, 0);
        mat[3][3] = new Node(0, 0);
        mat[3][4] = new Node(0, 0);


        return mat;
    }
    private static void Print(Node[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(mat[i][j].toString() + "\t");
            }
            System.out.println();
        }
    }

}
