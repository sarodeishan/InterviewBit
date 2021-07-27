package arrays;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//https://www.interviewbit.com/problems/repeat-and-missing-number-array/
public class RepeatAndMissingNumberArray {

    public static void main(String[] args) {

        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(3, 1, 2, 5, 3));
        ArrayList<Integer> result = repeatedNumber(A);
        System.out.println(result);
        Assert.assertEquals("Failed", "[3, 4]", result.toString());
        System.out.println("Success");

    }

    public static ArrayList<Integer> repeatedNumber(final List<Integer> A) {
        long diff=0;
        long squareDiff=0;
        int len = A.size();

        for(int i=1; i<=len; i++){

            long curr = A.get(i-1);
            diff += curr - i;
            squareDiff += ( curr-i )*(curr+i);
        }
        long sum = squareDiff/diff;

        long repeated = (diff+sum)/2;
        long missing = (sum-diff)/2;
        ArrayList<Integer> res = new ArrayList<>();
        res.add( (int)repeated );
        res.add( (int)missing );

        return res;
    }

}
