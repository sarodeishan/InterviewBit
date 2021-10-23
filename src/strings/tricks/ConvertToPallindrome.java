package strings.tricks;

import org.junit.Assert;

//https://www.interviewbit.com/problems/convert-to-palindrome/
public class ConvertToPallindrome {

    public static void main(String[] args) {
        Assert.assertEquals(1, solve("abcba"));
        System.out.println("Success");

        Assert.assertEquals(0, solve("abecbea"));
        System.out.println("Success");

        Assert.assertEquals(0, solve("abba"));
        System.out.println("Success");

        Assert.assertEquals(1, solve("aebba"));
        System.out.println("Success");
        
    }

    public static int solve(String A) {
        int result = 1;
        boolean singleCharacterRemoved = false;
        for (int i = 0, j = A.length() - 1; i < A.length() && j >= 0 && i <= j; i++, j--) {
            if (A.charAt(i) != A.charAt(j)) {
                if (singleCharacterRemoved) {
                    result = 0;
                    break;
                }
                if (A.charAt(i) == A.charAt(j - 1)) {
                    j--;
                    singleCharacterRemoved = true;
                } else if (A.charAt(j) == A.charAt(i + 1)) {
                    i++;
                    singleCharacterRemoved = true;
                } else {
                    result = 0;
                    singleCharacterRemoved = true;
                    break;
                }
            }
        }
        if (!singleCharacterRemoved && A.length() % 2 == 0) {
            result = 0;
        }
        return result;
    }

}
