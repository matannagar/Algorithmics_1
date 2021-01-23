package tests.airplane;

import java.awt.*;

public class practice_air_plane {
    public static void main(String[] args) {
        test();
//            System.out.println(bp.cheapestPrice);
//            System.out.println(bp.numOfPaths);
//            System.out.println(bp.getOnePath());
//            System.out.println(bp.getOnePathRec());
//            System.out.println(bp.getAllPathsRec());
//            System.out.println(bp.isOnBestPath(1, 1));
//            System.out.println(bp.isOnBestPath(1, 2));
//            System.out.println(bp.isOnBestPath(new Node[]{new Node(1, 1), new Node(1, 2), new Node(1, 3)}));
//            System.out.println(bp.isOnBestPath(new Node[]{new Node(1, 1), new Node(3, 1), new Node(3, 3)}));
//            System.out.println(bp.optimalPath());
//            Node[][] mat2 = new Node[6][6];
//            for (int i = 0; i < mat2.length; i++) {
//                for (int j = 0; j < mat2.length; j++) {
//                    mat2[i][j] = new Node(j == 4 ? 0 : 1, i == 4 ? 0 : 1);
//                }
//            }
//            BestPath b = new BestPath(mat2);
//            System.out.println(b.getAllPathsRec().size());
    }

    public static void test() {
        Node[][] mat = new Node[4][4];
        mat[0][0] = new Node(1, 2);
        mat[0][1] = new Node(1, 1);
        mat[0][2] = new Node(1, 3);
        mat[0][3] = new Node(1, 1);
        mat[1][0] = new Node(2, 3);
        mat[1][1] = new Node(5, 1);
        mat[1][2] = new Node(6, 3);
        mat[1][3] = new Node(1, 1);
        mat[2][0] = new Node(2, 4);
        mat[2][1] = new Node(7, 1);
        mat[2][2] = new Node(2, 3);
        mat[2][3] = new Node(0, 1);
        mat[3][0] = new Node(2, 1);
        mat[3][1] = new Node(1, 1);
        mat[3][2] = new Node(1, 1);
        mat[3][3] = new Node(1, 2);

        System.out.println(
        check_if_points_are_on_best_route(calculate_plane(mat), new Point(1, 0), new Point(mat.length - 1, mat[0].length - 1))
        );
//        System.out.println(shortest_path_x_y(calculate_plane(mat),new Point(1,1), new Point (2,3)));
    }

    public static class Node {
        int price, x, y, paths;

        public Node(int right, int down) {
            this.x = right;
            this.y = down;
            this.price = 0;
            this.paths = 1; //at least 1 path
        }

        @Override
        public String toString() {
            return "" + price;
        }
    }

    public static Node[][] calculate_plane(Node[][] mat) {
        int length_of_row = mat.length;
        int length_of_columns = mat[0].length;


        for (int i = 1; i < length_of_row; i++) { // - set price for the first line
            mat[0][i].price = mat[0][i - 1].price + mat[0][1].x;
        }
        for (int i = 1; i < length_of_columns; i++) { // - set price for the first row
            mat[i][0].price = mat[i - 1][0].price + mat[i - 1][0].y;
        }

        for (int i = 1; i < length_of_row; i++) {
            for (int j = 1; j < length_of_columns; j++) {
                int right = mat[i][j - 1].x + mat[i][j - 1].price;
                int down = mat[i - 1][j].y + mat[i - 1][j].price;
                mat[i][j].price = Math.min(right, down);
            }
        }
        Print(mat);
        return mat;
    }

    public static int shortest_path_x_y(Node[][] mat, Point p1, Point p2) {
        //we need src to be lower than dest (src.y < dest.y, src.x < dest.x)
        Point src = p1;
        Point dest = p2;
        if (p1.y > p2.y) {
            src = p2;
            dest = p1;
        }
        int temp_length_of_columns = dest.y - src.y + 1; //higher y - lower y (down)
        int temp_length_of_row = Math.abs(dest.x - src.x) + 1; // higher x - lower x (right)

        Node[][] temp_mat = new Node[temp_length_of_row/*num of columns*/][temp_length_of_columns/*num of rows*/];

        for (int i = 0; i < temp_length_of_row; i++) {
            for (int j = 0; j < temp_length_of_columns; j++) {
                temp_mat[i][j] = new Node(0, 0);
            }
        }

        for (int i = 1; i < temp_length_of_columns; i++) {
            temp_mat[0][i].price =
                    mat[src.y][src.x + i - 1].x
                    + temp_mat[0][i - 1].price;
        }
        for (int i = 1; i < temp_length_of_row; i++) {
            temp_mat[i][0].price =
                    mat[src.y + i - 1][src.x].x +
                            temp_mat[i - 1][0].price;
        }

        for (int i = 1; i < temp_length_of_row; i++) {
            for (int j = 1; j < temp_length_of_columns; j++) {
                int down = temp_mat[i - 1][j].price +
                        mat[i - 1 + src.y][j + src.y].y;
                int right = temp_mat[i][j - 1].price +
                        mat[i + src.y][j - 1 + src.x].x;
                temp_mat[i][j].price = Math.min(down, right);
            }
        }
//        System.out.println();
//        Print(temp_mat);
        return temp_mat[temp_mat.length-1][temp_mat[0].length-1].price;
    }

    public static boolean check_if_points_are_on_best_route(Node[][] mat, Point p1, Point p2) {
        int total = mat[mat.length-1][mat[0].length-1].price;
        Point start = new Point(0,0);
        Point end = new Point(mat.length-1, mat[0].length-1);
//        System.out.println(shortest_path_x_y(mat, start, p1));
//        System.out.println(shortest_path_x_y(mat, p1, p2));
//        System.out.println(shortest_path_x_y(mat, p2, end));
        return total == shortest_path_x_y(mat, start, p1) + shortest_path_x_y(mat, p1, p2) + shortest_path_x_y(mat, p2, end);
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
