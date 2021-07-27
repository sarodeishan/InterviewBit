package arrays;

import org.junit.Assert;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//https://www.interviewbit.com/problems/max-distance/
public class MaxDistance {

    public static void main(String[] args) {
        List<Integer> A = Arrays.asList(3, 5, 4, 2);
        int result = maximumGap(A);
        Assert.assertEquals("Failed", 2, result);
        System.out.println("Success");

        A = Arrays.asList(1, 1, 3, 3);
        result = maximumGap(A);
        Assert.assertEquals("Failed", 3, result);
        System.out.println("Success");

        A = Arrays.asList(5, 4, 3, 2, 1);
        result = maximumGap(A);
        Assert.assertEquals("Failed", 0, result);
        System.out.println("Success");

    }

    public static int maximumGap(final List<Integer> A) {

        class Pair implements Comparable<Pair> {
            int val, idx;

            Pair(int val, int idx) {
                this.val = val;
                this.idx = idx;
            }

            public int compareTo(Pair p) {
                return this.val - p.val;
            }
        }

        Pair P[] = new Pair[A.size()];
        for (int i = 0; i < A.size(); i++) {
            P[i] = new Pair(A.get(i), i);
        }
        Arrays.sort(P);
        int currMin = P[0].idx, res = 0;
        for (int i = 1; i < P.length; i++) {
            res = Math.max(res, P[i].idx - currMin);
            currMin = Math.min(currMin, P[i].idx);
        }
        return res;
    }

}
