package arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//https://www.interviewbit.com/old/problems/next-permutation/
public class ArrangementNextPermutation {

    public static void main(String[] args) {

        System.out.println(Stream.of("50","20","113").sorted().collect(Collectors.toList()));
        System.out.println(Stream.of("50","20","113").sorted(Comparator.reverseOrder()).collect(Collectors.toList()));

        ArrayList<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(2);
        input.add(3);
        nextPermutation(input);
        System.out.println(input);
        System.out.println("Success");

        input = new ArrayList<>();
        input.add(3);
        input.add(2);
        input.add(1);
        nextPermutation(input);
        System.out.println(input);
        System.out.println("Success");

        input = new ArrayList<>();
        input.add(1);
        input.add(1);
        input.add(5);
        nextPermutation(input);
        System.out.println(input);
        System.out.println("Success");

        input = new ArrayList<>();
        input.add(20);
        input.add(50);
        input.add(113);
        nextPermutation(input);
        System.out.println(input);
        System.out.println("Success");

    }

    public static ArrayList<Integer> nextPermutation(ArrayList<Integer> A) {
        for (int i = A.size() - 1; i > 0; i--) {
            if (A.get(i).toString().compareTo(A.get(i - 1).toString()) > 0) {
                int temp = A.get(i);
                A.set(i, A.get(i - 1));
                A.set(i - 1, temp);
                return A;
            }
        }
        Collections.reverse(A);
        return A;
    }


}
