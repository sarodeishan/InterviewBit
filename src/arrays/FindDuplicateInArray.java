package arrays;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

//https://www.interviewbit.com/problems/find-duplicate-in-array/
public class FindDuplicateInArray {

    public static void main(String[] args) {
        List<Integer> A = Arrays.asList(3, 4, 1, 4, 1);
        int result = repeatedNumber(A);
        Assert.assertEquals("Failed", 4, result);
        System.out.println("Success");

        A = Arrays.asList(0, 1, -1, 0);
        result = repeatedNumber(A);
        Assert.assertEquals("Failed", 0, result);
        System.out.println("Success");

    }

    public static int repeatedNumber(final List<Integer> A) {
        int result = -1;
        HashSet<Integer> seenNumber = new HashSet<>();
        for (int number : A) {
            boolean added = seenNumber.add(number);
            if (!added) {
                result = number;
                break;
            }
        }
        return result;
    }
}