package tests.LCS;

import java.util.*;

public class all_SS_of_X_Y {
    // Declare a global list
    static List<String> al = new ArrayList<>();
    static List<String> a1 = new ArrayList<>();

    // Creating a public static Arraylist such that
    // we can store values
    // IF there is any question of returning the
    // we can directly return too// public static
    // ArrayList<String> al = new ArrayList<String>();
    public static void main(String[] args) {
        String s = "ABCDAE";
        String k = "BCADB";
        findsubsequences(s, ""); // Calling a function
        findsubsequences2(k, ""); // Calling a function
        List<String> end = new ArrayList<>(new HashSet<>(al));
        List<String> end2 = new ArrayList<>(new HashSet<>(a1));
        List<String> ans = new ArrayList<>();
        int i = 3;
        for (String value : end) {
            for (String item : end2) {
                if (value.equals(item) && value.length() == i) {
                    ans.add(value);
                }
            }
        }
        System.out.println(ans);
    }
    private static void findsubsequences(String s,String ans) {
        if (s.length() == 0) {
            al.add(ans);
            return;
        }
        findsubsequences(s.substring(1), ans +s.charAt(0));
        findsubsequences(s.substring(1), ans);
    }
    private static void findsubsequences2(String s,String ans) {
        if (s.length() == 0) {
            a1.add(ans);
            return;
        }
        findsubsequences2(s.substring(1), ans +s.charAt(0));
        findsubsequences2(s.substring(1), ans);
    }
}

