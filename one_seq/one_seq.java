package one_seq;

public class one_seq {
    public static void main(String[] args) {
        int[] arr = {1, 1, 0,1,0,0,0,1,1,1,1,0,1};
        System.out.println(one_sequence(arr));
    }

    public static int one_sequence(int[] arr) {
        int ans = 0,count = 0;

        int[] temp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1)
                temp[i] = count++;
            else
                count = 0;
            if (count > ans)
                ans = count;
        }
        return ans;
    }
}
