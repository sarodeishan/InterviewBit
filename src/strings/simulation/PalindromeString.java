package strings.simulation;

import org.junit.Assert;

public class PalindromeString {


    public static void main(String[] args) {
        Assert.assertEquals(1, isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println("Success");
        Assert.assertEquals(0, isPalindrome("race a car"));
        System.out.println("Success");
    }

    public static int isPalindrome(String A) {
        StringBuilder forward = new StringBuilder();
        for (int i = 0; i < A.length(); i++) {
            char c = A.charAt(i);
            if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) {
                forward.append(c);
            }
        }
        return forward.toString().equalsIgnoreCase(forward.reverse().toString()) ? 1 : 0;
    }


}
