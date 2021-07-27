package binarysearch.searchAnswer;

import org.junit.Assert;

import java.util.ArrayList;

//https://www.interviewbit.com/old/problems/allocate-books/
public class AllocateBooks {


    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>();
        input.add(12);
        input.add(34);
        input.add(67);
        input.add(90);
        Assert.assertEquals(113, books(input, 2));
        System.out.println("Success");

        input.clear();
        input.add(5);
        input.add(17);
        input.add(100);
        input.add(11);

        Assert.assertEquals(100, books(input, 4));
        System.out.println("Success");
    }

    public static int books(ArrayList<Integer> A, int B) {
        int min = 0, max = 0, answer = -1;
        if (B > A.size()) {
            return -1;
        }
        for (int i = 0; i < A.size(); i++) {
            max += A.get(i);
            min = Math.max(min, A.get(i));
        }
        while (min <= max) {
            int mid = (max - min) / 2 + min;
            int students = 1, pages = 0;
            for (int i = 0; i < A.size(); i++) {
                if (pages + A.get(i) > mid) {
                    students++;
                    pages = A.get(i);
                } else {
                    pages += A.get(i);
                }
            }
            if (students <= B) {
                answer = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return answer;
    }
}
