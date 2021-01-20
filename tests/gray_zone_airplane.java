package tests;

import java.awt.*;

public class gray_zone_airplane {

    static class Node {
        int x, y, price, numOfPaths, entryFromTheEnd;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
            price = 0;
            entryFromTheEnd = 0;
            numOfPaths = 1;
        }

        @Override
        public String toString() {
            return ""+ price ;
        }
    }

    public static int grayZone(Node[][] mat, Point p1, Point p2) {
        Point src;
        Point dest;
        if (p1.y>p2.y) {
            src = p2;
            dest = p1;
        }
        else {
            src = p1;
            dest = p2;
        }
        int start_at_x = Math.min(src.x,dest.x);
        int end_at_x = Math.max(src.x,dest.x);
        int column = mat.length, row = mat[0].length;
        //set prices for first column
        for (int i = 1; i < column; i++) {
//
            mat[i][0].price = mat[i - 1][0].y + mat[i - 1][0].price;
        }
        //set prices for first row
        for (int j = 1; j < row; j++) {

            mat[0][j].price = mat[0][j - 1].price + mat[0][j - 1].x;
        }


        for (int i =src.y ; i <= dest.y; i++) {
            for (int j = start_at_x; j <=end_at_x ; j++) {
                mat[i][j].price = Integer.MAX_VALUE-100;
            }
        }

        Print(mat);
        //set prices for the rest of the nodes
        for (int i = 1; i < column; i++) {
            for (int j = 1; j < row; j++) {
                if (i<= dest.y && i>=src.y && j>=start_at_x && j<=end_at_x){
                    mat[i][j].price = Integer.MAX_VALUE;
                }
                else{

                    int y = mat[i - 1][j].price + mat[i - 1][j].y;//calculates the value of node + y_price
                    int x = mat[i][j - 1].price + mat[i][j - 1].x;//calculates the value of node + x_price
                    mat[i][j].price = Math.min(x, y); //sets which one is better

                    //calculate num of paths
                    if (y < x) mat[i][j].numOfPaths = mat[i - 1][j].numOfPaths;
                    else if (y > x) mat[i][j].numOfPaths = mat[i][j - 1].numOfPaths;
                    else mat[i][j].numOfPaths = mat[i][j - 1].numOfPaths + mat[i - 1][j].numOfPaths;
                }
            }
        }
        int numOfPaths = mat[column - 1][row - 1].numOfPaths;
        int cheapestPrice = mat[column - 1][row - 1].price;
        Print(mat);
        return mat[column-1][row-1].price;
    }
    public static void main(String[] args) {
        System.out.println(grayZone(InitMat1(), new Point(2, 0), new Point(3, 2)));
    }

    private static Node[][] InitMat1() {
        Node[][] mat = new Node[4][4];

        mat[0][0] = new Node(1, 2);
        mat[0][1] = new Node(5, 4);
        mat[0][2] = new Node(3, 9);
        mat[0][3] = new Node(0, 9);
        mat[1][0] = new Node(5, 4);
        mat[1][1] = new Node(4, 4);
        mat[1][2] = new Node(7, 4);
        mat[1][3] = new Node(0, 2);
        mat[2][0] = new Node(8, 3);
        mat[2][1] = new Node(5, 6);
        mat[2][2] = new Node(8, 0);
        mat[2][3] = new Node(0, 0);
        mat[3][0] = new Node(2, 0);
        mat[3][1] = new Node(4, 0);
        mat[3][2] = new Node(5, 0);
        mat[3][3] = new Node(0, 0);
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
