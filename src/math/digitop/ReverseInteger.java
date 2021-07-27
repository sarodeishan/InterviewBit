package math.digitop;

import org.junit.Assert;

import java.util.stream.Collectors;
import java.util.stream.Stream;

//https://www.interviewbit.com/old/problems/reverse-integer/
public class ReverseInteger {

    public static void main(String[] args) {
        Assert.assertEquals(321, reverse(123));
        System.out.println("Success");
        Assert.assertEquals(-321, reverse(-123));
        System.out.println("Success");
        Assert.assertEquals(0, reverse(-1146467285));
        System.out.println("Success");
        Assert.assertEquals(0, reverse(-81328070));
        System.out.println("Success");
    }

    public static int reverse(int A) {
        Integer number = Math.abs(A);
        String input = number.toString();
        String reversed = new StringBuilder(input).reverse().toString();
        try {
            Integer result = Integer.valueOf(reversed);
            if (A < 0) {
                result = result * -1;
            }
            return result;
        } catch (NumberFormatException nfe) {
            return 0;
        }

    }

}
