package strings.search;

import org.junit.Assert;

//https://www.interviewbit.com/problems/amazing-subarrays/
public class AmazingSubarrays {


    public static void main(String[] args) {
        Assert.assertEquals(6, solve("ABEC"));
        System.out.println("Success");
    }

    public static int solve(String A) {
        int result = 0;
        for (int i = 0; i < A.length(); i++) {
            if (isVowel(A.charAt(i))) {
                result += A.length() - i;
                result %= 10003;
            }
        }
        return result % 10003;
    }

    private static boolean isVowel(char character) {
        char lowerCase = Character.toLowerCase(character);
        return lowerCase == 'a' || lowerCase == 'e' || lowerCase == 'i' || lowerCase == 'o' || lowerCase == 'u';
    }

}
