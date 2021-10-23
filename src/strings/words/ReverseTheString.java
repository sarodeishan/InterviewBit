package strings.words;

import org.junit.Assert;

//https://www.interviewbit.com/problems/reverse-the-string/
public class ReverseTheString {

    public static void main(String[] args) {
        Assert.assertEquals("blue is sky the", solve(" the  sky is  blue "));
        System.out.println("Success");

        Assert.assertEquals("ib is this", solve(" this   is ib "));
        System.out.println("Success");


    }

    public static String solve(String A) {
        StringBuilder result = new StringBuilder();
        A = A.trim();
        String[] words = A.split(" ");
        for (int i = words.length - 1; i >= 0; i--) {
            result.append(words[i]);
            if (!words[i].equalsIgnoreCase("") && i != 0) {
                result.append(" ");
            }
        }
        return result.toString();
    }
}
