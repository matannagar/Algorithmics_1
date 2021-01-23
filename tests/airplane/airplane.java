package tests.airplane;

import java.awt.*;
import java.util.Arrays;
import java.util.Comparator;

public class airplane {
    public static void main(String[] args) {
        Point[] arr = {new Point(0, 0), new Point(2, 2), new Point(3, 3)};
        System.out.println(points_on_SP(InitMat1(), arr));
        System.out.println(shortest_path(InitMat1(), 0, 0, 2, 3));
    }

    static class Node {
        int right, down, min_price, numOfPaths, valueFromEnd;

        public Node(int down, int right) {
            this.right = right;
            this.down = down;
            min_price = 0;
            valueFromEnd = 0;
            numOfPaths = 1;
        }

        @Override
        public String toString() {
            return "" + min_price;
        }
    }

    private static void Print(Node[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(mat[i][j].toString() + "\t");
            }
            System.out.println();
        }
    }

    public static int shortest_path(Node[][] matrix, int i1, int j1, int i2, int j2) {
        Node[][] temp = new Node[j2 - j1 + 1][i2 - i1 + 1];
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[0].length; j++) {
                temp[i][j] = new Node(0, 0);
            }
        }
        for (int i = 1; i < j2 - j1 + 1; i++) {
            temp[i][0].min_price = matrix[i - 1 + j1][i1].down + temp[i - 1][0].min_price;

        }
        for (int j = 1; j < i2 - i1 + 1; j++) {
            temp[0][j].min_price = matrix[j1][j - 1 + i1].right + temp[0][j - 1].min_price;
        }
        for (int i = 1; i < j2 - j1 + 1; i++) {
            for (int j = 1; j < i2 - i1 + 1; j++) {
                int y = temp[i - 1][j].min_price + matrix[i - 1 + j1][j + i1].down;
                int x = temp[i][j - 1].min_price + matrix[i + j1][j - 1 + i1].right;
                temp[i][j].min_price = Math.min(x, y);
            }
        }
        Print(temp);
        return temp[j2 - j1][i2 - i1].min_price;
    }

    public static Point[] sort_points(Point[] points) {
        Arrays.sort(points, Comparator.comparingInt(o -> o.x));
        Arrays.sort(points, Comparator.comparingInt(o -> o.y));
        return points;
    }

    public static boolean points_on_SP(Node[][] mat, Point[] points) {
        Point src = new Point(0, 0);
        Point dest = new Point(mat.length - 1, mat[0].length - 1);
        int shortest_path = shortest_path(mat, src.y, src.x, dest.y, dest.x);
        System.out.println(shortest_path);

        int total = 0;
        for (int i = 0; i < points.length - 1; i++) {
            total += shortest_path(mat, points[i].y, points[i].x, points[i + 1].y, points[i + 1].x);
        }
        total += shortest_path(mat, src.y, src.x, points[0].y, points[0].x) + shortest_path(mat, points[points.length - 1].y, points[points.length - 1].x, dest.y, dest.x);
        return total == shortest_path;
    }

    private static Node[][] InitMat1() {
        Node[][] mat = new Node[4][5];

        mat[0][0] = new Node(1, 8);
        mat[0][1] = new Node(8, 8);
        mat[0][2] = new Node(8, 8);
        mat[0][3] = new Node(9, 8);
        mat[0][4] = new Node(8, 0);
        mat[1][0] = new Node(1, 1);
        mat[1][1] = new Node(1, 8);
        mat[1][2] = new Node(8, 8);
        mat[1][3] = new Node(8, 8);
        mat[1][4] = new Node(8, 0);
        mat[2][0] = new Node(1, 8);
        mat[2][1] = new Node(8, 1);
        mat[2][2] = new Node(8, 1);
        mat[2][3] = new Node(0, 8);
        mat[2][4] = new Node(8, 0);

        mat[3][0] = new Node(0, 1);
        mat[3][1] = new Node(0, 2);
        mat[3][2] = new Node(0, 0);
        mat[3][3] = new Node(0, 0);
        mat[3][4] = new Node(0, 0);
        return mat;
    }
}
