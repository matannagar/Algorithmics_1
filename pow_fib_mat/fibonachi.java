package pow_fib_mat;

public class fibonachi {
    public static void main(String[] args) {
        System.out.println(whatFibo(5));
    }
    public static int whatFibo(int index) { // לעיל שהוסבר כפי הראשית הפונקציה
        int[][] mat = {{1,1},{1,0}};
        int[][] ans = fiboRec(mat,index-1);
        return ans[0][0];
    }
    public static int[][] fiboRec(int[][] mat, int index) {
        int[][] flag = {{1,0},{0,1}}; // I במטריצה הכפלה - עצירה תנאי
        if (index==0) return flag;
        else if (index%2==0)
            return fiboRec(KefelMatrix(mat,mat),index/2);
        else return
                    KefelMatrix(mat, fiboRec(KefelMatrix(mat,mat),(index-1)/2));
    }
//    פונקציית עזר לחישוב כפל של מטריצה 2 על 2 כפול מטריצה 2 על 2//
    public static int[][] KefelMatrix(int[][] mat1, int[][] mat2) {
        int[][] matAns = new int[2][2];
        matAns[0][0] = mat1[0][0]*mat2[0][0] + mat1[0][1]*mat2[1][0];
        matAns[0][1] = mat1[0][0]*mat2[0][1] + mat1[0][1]*mat2[1][1];
        matAns[1][0] = mat1[1][0]*mat2[0][0] + mat1[1][1]*mat2[1][0];
        matAns[1][1] = mat1[1][0]*mat2[0][1] + mat1[1][1]*mat2[1][1];
        return matAns;
    }
}
