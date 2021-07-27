package math.numberencoding;

import org.junit.Assert;

import java.util.*;


//https://www.interviewbit.com/problems/next-similar-number/
public class NextSimilarNumber {

    public static void main(String[] args) {
        Assert.assertEquals("251678", solve("218765"));
        System.out.println("Success");
        Assert.assertEquals("-1", solve("4321"));
        System.out.println("Success");
        Assert.assertEquals("892957", solve("892795"));
        System.out.println("Success");
    }

    public static String solve(String A) {
        StringBuilder input = new StringBuilder(A);
        StringBuilder result = new StringBuilder();
        int i = A.length() - 1;
        for (; i > 0; i--) {
            if (A.charAt(i) <= A.charAt(i - 1)) {
                continue;
            } else {
                break;
            }
        }
        if (i == 0) {
            return "-1";
        } else {
            //append prefix numbers
            final int partitionNumberIndex = i - 1;
            result.append(input.substring(0, partitionNumberIndex));
            input.delete(0, partitionNumberIndex);
            //append a number from suffix which is immediately greater than number at partitionNumber otherwise take the smallest number
            int immediateGreaterIndex;
            for (immediateGreaterIndex = input.length() - 1; immediateGreaterIndex > 1; immediateGreaterIndex--) {
                if (input.charAt(0) < input.charAt(immediateGreaterIndex)) {
                    break;
                }
            }
            result.append(input.charAt(immediateGreaterIndex));
            input.deleteCharAt(immediateGreaterIndex);
            //sort the remaining array in ascending order and append to result
            char[] remainingChars = input.toString().toCharArray();
            Arrays.sort(remainingChars);
            result.append(remainingChars);
        }
        return result.toString();
    }

}
