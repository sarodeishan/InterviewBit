package arrays;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//https://www.interviewbit.com/problems/first-missing-integer/
public class FirstMissingInteger {

    public static void main(String[] args) {
        List<Integer> A = Arrays.asList(1, 2, 0);
        int result = firstMissingPositive(A);
        Assert.assertEquals("Failed", 3, result);
        System.out.println("Success");

        A = Arrays.asList(3, 4, -1, 1);
        result = firstMissingPositive(A);
        Assert.assertEquals("Failed", 2, result);
        System.out.println("Success");

        A = Arrays.asList(-8, -7, -6);
        result = firstMissingPositive(A);
        Assert.assertEquals("Failed", 1, result);
        System.out.println("Success");
    }

    public static int firstMissingPositive(List<Integer> A) {
        Collections.sort(A);
        int result = 1;
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) <= 0) {
                continue;
            } else if (A.get(i) == result) {
                result++;
            } else {
                break;
            }
        }
        return result;
    }

}
