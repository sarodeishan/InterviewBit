package arrays;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://www.interviewbit.com/problems/partitions/
public class Partition {

    public static void main(String[] args) {
        List<Integer> A = Arrays.asList(1, 2, 3, 0, 3);
        int result = solve(5, A);
        Assert.assertEquals("Failed", 2, result);
        System.out.println("Success");

        A = Arrays.asList(0, 1, -1, 0);
        result = solve(4, A);
        Assert.assertEquals("Failed", 1, result);
        System.out.println("Success");

        A = Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
        result = solve(18, A);
        Assert.assertEquals("Failed", 1, result);
        System.out.println("Success");
    }

    public static int solve(int A, List<Integer> B) {
        int result = 0;
        List<Long> sums = new ArrayList<>();
        sums.add(new Long(B.get(0).intValue()));
        for (int i = 1; i < B.size(); i++) {
            sums.add(i, new Long(B.get(i).intValue()) + sums.get(i - 1));
        }
        if (sums.get(sums.size()-1) % 3 == 0) {
            for (int i = 1; i < B.size(); i++) {
                long sumFirst = sums.get(i - 1);
                for (int j = i; j < B.size() - 1; j++) {
                    long sumMid = sums.get(j) - sums.get(i - 1);
                    long sumLast = sums.get(B.size() - 1) - sums.get(j);
                    if (sumFirst == sumMid && sumMid == sumLast) {
                        result++;
                    }
                }
            }
        }
        return result;
    }
//
//    public static int solve(int A, List<Integer> B) {
//        int sum =0;
//        int count = 0;
//        int result =0;
//        int cummulativeSum =0;
//
//        for(Integer i: B){
//            sum += i;
//        }
//
//        if(sum%3 !=0){
//            return 0;
//        }
//
//        for(int i=0;i<A;i++){
//            cummulativeSum += B.get(i);
//
//            if(cummulativeSum == ((2*sum)/3) && i >= 1 && i<= A-2){
//                result += count;
//            }
//
//            if(cummulativeSum == sum/3){
//                count +=1;
//                // continue;
//            }
//
//        }
//        return result;
//    }

}
