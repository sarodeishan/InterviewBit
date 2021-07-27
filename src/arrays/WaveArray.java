package arrays;

import org.junit.Assert;

import java.util.*;

//https://www.interviewbit.com/problems/wave-array/
public class WaveArray {

    public static void main(String[] args) {
        List<Integer> A = Arrays.asList(1, 2, 3, 4);
        List<Integer> result = wave(A);
        System.out.println(result);
        System.out.println("Success");

        A = Arrays.asList(1, 2, 3, 4, 5);
        result = wave(A);
        System.out.println(result);
        System.out.println("Success");

        A = Arrays.asList(0, 1, -1, 0);
        result = wave(A);
        System.out.println(result);
        System.out.println("Success");

    }

    public static List<Integer> wave(List<Integer> A) {
        Collections.sort(A);
        for (int i = 0; i < A.size()-1; i+=2) {
            swap(A, i, i+1);
        }
        return A;
    }

    public static void swap(List<Integer> A, int i, int j) {
        int temp =A.get(i);
        A.set(i, A.get(j));
        A.set(j, temp);
    }
}