package arrays;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

//https://www.interviewbit.com/problems/add-one-to-number/
public class AddOneToNumber {

    public static void main(String[] args) {
        List<Integer> A = Arrays.asList(1, 2, 3);
        List<Integer> result = plusOne(A);
        String number = result.stream().map(i -> i.toString()).reduce("", (s, s2) -> s + s2);
        Assert.assertEquals("Failed", "124", number);
        System.out.println("Success");

        A = Arrays.asList(0, 1, 2, 3);
        result = plusOne(A);
        number = result.stream().map(i -> i.toString()).reduce("", (s, s2) -> s + s2);
        Assert.assertEquals("Failed", "124", number);
        System.out.println("Success");

        A = Arrays.asList(1, 2, 9);
        result = plusOne(A);
        number = result.stream().map(i -> i.toString()).reduce("", (s, s2) -> s + s2);
        Assert.assertEquals("Failed", "130", number);
        System.out.println("Success");

        A = Arrays.asList(9, 9, 9, 9, 9);
        result = plusOne(A);
        number = result.stream().map(i -> i.toString()).reduce("", (s, s2) -> s + s2);
        Assert.assertEquals("Failed", "100000", number);
        System.out.println("Success");

    }

    public static List<Integer> plusOne(List<Integer> A) {
        LinkedList<Integer> result = new LinkedList<>();
        List<Integer> inputWithoutLeadingZero = new ArrayList<>();
        int start;
        for (start = 0; start < A.size() && A.get(start) == 0; start++) {
        }
        for (int i = start; i < A.size(); i++) {
            inputWithoutLeadingZero.add(A.get(i));
        }

        int carry = 1;
        for (int i = inputWithoutLeadingZero.size() - 1; i >= 0; i--) {
            int current = inputWithoutLeadingZero.get(i);
            current = current + carry;
            if (current >= 10) {
                carry = current / 10;
                result.addFirst(current % 10);
            } else {
                carry = 0;
                result.addFirst(current);
            }
        }
        if (carry != 0) {
            result.addFirst(carry);
        }
        return new ArrayList<>(result);
    }

}
