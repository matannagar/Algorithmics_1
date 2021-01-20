package tests;

public class min_max {
    public static void main(String[] args) {
        int[] arr = {1,2,3,6,-2,100};
        System.out.println(diff(arr));
    }

    // Function to calculate maximum difference between two elements in the
    // array such that smaller element appears before the larger element
    public static int diff(int[] A)
    {
        int diff = Integer.MIN_VALUE;
        int n = A.length;
        int max_so_far = A[n-1];

        // traverse the array from right and keep track the maximum element
        for (int i = n - 2; i >= 0; i--)
        {
            // update max if current element is greater than the max element
            if (A[i] > max_so_far) {
                max_so_far = A[i];
            }
            // if the current element is less than the maximum element,
            // then update the difference if required
            else {
                diff = Integer.max(diff, max_so_far - A[i]);
            }
        }

        // return difference
        return diff;
    }
}

