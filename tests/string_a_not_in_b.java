package tests;

public class string_a_not_in_b {

    public static String a_not_in_b(String x, String y){
        String s ="";
        if (x.length()>y.length()) s=x;// אם האורך של איקס גדול מזה של Y אז הרי שהמחרוזת הלא משותפת הארוכה ביותר היא X עצמו
        else if (y.contains(x)) s = null; // אם איקס מוכל בY אז הרי שכל המחרוזת של איקס היא חלק מY ולכן הפתרון ריק
        else s = x;
        return s;
    }
    public static String a_not_in_b_two_way(String x, String y){
        String s ="";
        if (x.length()>y.length()) s=x; // אם האורך של איקס גדול מזה של Y אז הרי שהמחרוזת הלא משותפת הארוכה ביותר היא X עצמו
        else if (x.length()<y.length()) s=y;// אם האורך של איקס גדול מזה של Y אז הרי שהמחרוזת הלא משותפת הארוכה ביותר היא X עצמו
        else { // they are equal in size
            if (x.equals(y)) s=null; // if they are equal there is no ans
            else s = x; //or y --> they are not equal and each of the string is the lncs
        }
        return s;
    }
}
