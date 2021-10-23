package strings.search;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.Collections;

//https://www.interviewbit.com/old/problems/stringoholics/
public class Stringoholics {

    public static void main(String[] args) {
        ArrayList<String> input = new ArrayList<>();
        input.add("a");
        input.add("ababa");
        input.add("aba");
        Assert.assertEquals(4, solve(input));
        System.out.println("Success");

        input.clear();
        input.add("a");
        input.add("aa");
        Assert.assertEquals(1, solve(input));
        System.out.println("Success");
    }

    public static int solve(ArrayList<String> A) {
        ArrayList<String> rotated = new ArrayList<>(A);
        ArrayList<Long> timesToOriginal = new ArrayList<>(A.size());
        for (int i = 0; i < rotated.size(); i++) {
            long times = 1;
            while (true) {
                String rotatedString = circularRotateString(rotated.get(i), times);
                if (rotatedString.equals(A.get(i))) {
                    timesToOriginal.add(times);
                    break;
                } else {
                    rotated.set(i, rotatedString);
                }
                times++;
            }
        }
        return lcmOfArray(timesToOriginal);
    }

    private static int lcmOfArray(ArrayList<Long> input) {
        long value = 1;
        for (int i = 0; i < input.size(); i++) {
            for (int j = i + 1; j < input.size(); j++) {
                input.set(j, input.get(j) / gcd(input.get(i), input.get(j)));
            }
            value = (value % 1000000007 * (input.get(i) % 1000000007)) % 1000000007;
        }
        return (int)value % 1000000007;
    }

    private static String circularRotateString(String input, long rotateLengthInput) {
        int rotateLength = (int)rotateLengthInput % input.length();
        if (rotateLength == 0) {
            return input;
        }
        return input.substring(rotateLength) + input.substring(0, rotateLength);
    }

    private static long gcd(long a, long b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }
}
