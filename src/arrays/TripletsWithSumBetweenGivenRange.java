package arrays;

import org.junit.Assert;

import java.util.*;

//https://www.interviewbit.com/problems/triplets-with-sum-between-given-range/
public class TripletsWithSumBetweenGivenRange {

    public static void main(String[] args) {
        List<String> A = Arrays.asList("0.6", "0.7", "0.8", "1.2", "0.4");
        int result = solve(A);
        Assert.assertEquals("Failed", 1, result);
        System.out.println("Success");

//        A = Arrays.asList(1, 1, 3, 3);
//        result = solve(A);
//        Assert.assertEquals("Failed", -1, result);
//        System.out.println("Success");


    }

    public static int solve(List<String> A) {
        List<Double> queue = new ArrayList<>(3);
        double sum = 0;
        for (String s : A) {
            double val = Double.parseDouble(s);
            if (queue.size() < 3) {
                queue.add(val);
                sum += Double.parseDouble(s);
            } else if (queue.size() == 3 && sum >= 2 && queue.get(2) > val) {
                sum -= queue.get(2);
                sum += val;
                queue.remove(2);
                queue.add(val);
            } else if (queue.size() == 3 && sum < 1 && val > queue.get(0)) {
                sum -= queue.get(0);
                sum += val;
                queue.remove(0);
                queue.add(val);
            }
            Collections.sort(queue);
            if (queue.size() == 3 && sum > 1 && sum < 2)
                return 1;
        }

        return 0;
    }

}
