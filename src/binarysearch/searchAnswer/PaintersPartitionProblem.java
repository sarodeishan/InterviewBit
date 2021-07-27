package binarysearch.searchAnswer;

import org.junit.Assert;

import java.util.ArrayList;

//https://www.interviewbit.com/old/problems/painters-partition-problem/
public class PaintersPartitionProblem {


    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(10);
        Assert.assertEquals(50, paint(2,5,input));
        System.out.println("Success");

        input.clear();
        input.add(1);
        input.add(8);
        input.add(11);
        input.add(3);

        Assert.assertEquals(11, paint(10,1,input));
        System.out.println("Success");

        input.clear();
        input.add(658);
        input.add(786);
        input.add(531);
        input.add(47);
        input.add(169);
        input.add(397);
        input.add(914);

        Assert.assertEquals(9140, paint(5, 10,input));
        System.out.println("Success");

        input.clear();
        input.add(1000000);
        input.add(1000000);

        Assert.assertEquals(9400003, paint(1, 1000000,input));
        System.out.println("Success");
    }

    public static int paint(int A, int B, ArrayList<Integer> C) {
        if (A >= C.size()) {
            int maxBoard = C.stream().mapToInt(Integer::intValue).max().getAsInt();
            return (int) (((long) maxBoard * (long) B) % 10000003);
        } else {
            int min = 0, max = 0;
            for (int i = 0; i < C.size(); i++) {
                max += C.get(i);
                min = Math.max(min, C.get(i));
            }
            int minBoard = Integer.MAX_VALUE;
            while (min <= max) {
                int mid = (max - min) / 2 + min;
                int painters = 1, boards = 0, maxBoard = 0 ;
                for (int i = 0; i < C.size(); i++) {
                    if (boards + C.get(i) > mid) {
                        painters++;
                        boards = C.get(i);
                    } else {
                        boards += C.get(i);
                    }
                    maxBoard = Math.max(maxBoard, boards);
                }
                if (painters <= A) {
                    minBoard = Math.min(minBoard, maxBoard);
                    max = mid - 1;
                } else {
                    min = mid + 1;
                }
            }
            return (int) (((long) minBoard * (long) B) % 10000003);
        }
    }
}
