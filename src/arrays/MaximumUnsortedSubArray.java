package arrays;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

//https://www.interviewbit.com/problems/maximum-unsorted-subarray/
public class MaximumUnsortedSubArray {

    public static void main(String[] args) {
        List<Integer> A = Arrays.asList(1, 3, 2, 4, 5);
        System.out.println("Size:" + A.size());
        List<Integer> result = subUnsort(A);
        System.out.println("Answer: [1,2]");
        System.out.println(result);
        System.out.println("Success");

        A = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println("Size:" + A.size());
        result = subUnsort(A);
        System.out.println("Answer: [-1]");
        System.out.println(result);
        System.out.println("Success");

        A = Arrays.asList(2, 3, 5, 1, 4, 8, 7, 10);
        System.out.println("Size:" + A.size());
        result = subUnsort(A);
        System.out.println("Answer: [0,6]");
        System.out.println(result);
        System.out.println("Success");
    }

    public static ArrayList<Integer> subUnsort(List<Integer> A) {
        int cmin = Integer.MAX_VALUE, cmax = Integer.MIN_VALUE, l = -1, r = -1, i = 0;
        for (; i < A.size() - 1; i++) {
            if (A.get(i) > A.get(i + 1)) {
                l = i;
                break;
            }
        }
        if (l == -1) return new ArrayList<>(Arrays.asList(-1));

        for (i = A.size() - 1; i > 0; i--) {
            if (A.get(i) < A.get(i - 1)) {
                r = i;
                break;
            }
        }

        for (i = l; i <= r; i++) {
            cmin = Math.min(cmin, A.get(i));
            cmax = Math.max(cmax, A.get(i));
        }
        for (i = l - 1; i >= 0; i--) {
            if (A.get(i) > cmin) {
                l = i;
            }
        }
        for (i = r + 1; i < A.size(); i++) {
            if (A.get(i) < cmax) {
                r = i;
            }
        }
        return new ArrayList<>(Arrays.asList(l, r));
    }
}
