package strings.words;

import org.junit.Assert;

//https://www.interviewbit.com/problems/length-of-last-word/
public class LengthOfLastWord {

    public static void main(String[] args) {
        Assert.assertEquals(5, lengthOfLastWord("Hello World"));
        System.out.println("Success");

        Assert.assertEquals(0, lengthOfLastWord(""));
        System.out.println("Success");

        Assert.assertEquals(0, lengthOfLastWord(" "));
        System.out.println("Success");

        Assert.assertEquals(2, lengthOfLastWord("sad asd asds 12 "));
        System.out.println("Success");

    }

    public static int lengthOfLastWord(final String A) {
        int result = 0;
        int i = A.length() - 1;
        for (; i >= 0 && A.charAt(i) == ' '; i--) {
        }
        for (; i >= 0 && A.charAt(i) != ' '; i--) {
            result++;
        }
        return result;
    }
}
