package pizza_problem;

public class pizza_problem {
    public static void main(String[] args) {
        System.out.println(pizza(3,4));
    }
    public static int pizza(double x, int n) {
        int k = (int) x + 1;
        int p = n / (k + 1);
        int r = n % (k + 1);
        int ans = -1; // r=1 forbidden state

        if (r != 1) {
            double t = (x * p + r - 1) / ((x + 1) * p + r);
            if (t < x / (x + 1))
                ans = 1; //correct
            else
                ans = 0; // wrong
        }
        return ans;
    }
}
