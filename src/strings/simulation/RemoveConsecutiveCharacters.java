package strings.simulation;

import org.junit.Assert;

import java.util.ArrayList;

public class RemoveConsecutiveCharacters {


    public static void main(String[] args) {
        Assert.assertEquals("bcd", solve("aabcd", 2));
        System.out.println("Success");
        Assert.assertEquals("d", solve("aabbccd", 2));
        System.out.println("Success");
    }

    public static String solve(String A, int B) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < A.length(); i++) {
            char c = A.charAt(i);
            int start = i, end = i;
            for (int j = i + 1; j < A.length(); j++, i++) {
                if (c == A.charAt(j)) {
                    end = j;
                } else {
                    break;
                }
            }
            if (((end + 1) - start) != B) {
                result.append(A, start, end + 1);
            }
        }
        return result.toString();
    }

}
