package arrays;

import org.junit.Assert;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

//https://www.interviewbit.com/problems/largest-number/
public class ArrangementLargestNumber {

    public static void main(String[] args) {
        List<Integer> A = Arrays.asList(3, 30, 34, 5, 9);
        String result = largestNumber(A);
        Assert.assertEquals("Failed", "9534330", result);
        System.out.println("Success");

        A = Arrays.asList(0, 0, 0, 0, 0);
        result = largestNumber(A);
        Assert.assertEquals("Failed", "0", result);
        System.out.println("Success");

        A = Arrays.asList(12, 121);
        result = largestNumber(A);
        Assert.assertEquals("Failed", "12121", result);
        System.out.println("Success");


        A = Arrays.asList(813, 696, 751, 718, 303, 947, 67, 633, 821, 587, 907, 331, 193, 667, 99, 496, 619, 841, 339, 981, 908, 576, 832, 491, 574, 899, 875, 871, 594, 672, 708, 931, 237, 587, 224, 638, 485, 102, 475, 281, 722, 77, 903, 386, 263, 652);
        result = largestNumber(A);
        Assert.assertEquals("Failed", "999819479319089079038998758718418328218137775172271870869667672667652638633619594587587576574496491485475386339331303281263237224193102", result);
        System.out.println("Success");
    }

    public static String largestNumber(final List<Integer> A) {
        String result = A.parallelStream().map(Objects::toString).sorted((o1, o2) -> (o2 + o1).compareTo(o1 + o2)).collect(Collectors.joining());
        if (result.charAt(0) == '0') {
            return "0";
        }
        return result;
    }

}
