package math.numbertheory;

import org.junit.Assert;

import java.math.BigInteger;
import java.util.Arrays;


//https://www.interviewbit.com/old/problems/sorted-permutation-rank-with-repeats/
public class SortedPermutationRankWithRepeats {

    public static void main(String[] args) {
        Assert.assertEquals(1, findRank("abc"));
        System.out.println("Success");
        Assert.assertEquals(2, findRank("acb"));
        System.out.println("Success");
        Assert.assertEquals(4, findRank("acdb"));
        System.out.println("Success");
        Assert.assertEquals(8, findRank("badc"));
        System.out.println("Success");
        Assert.assertEquals(342501, findRank("DTNGJPURFHYEW"));
        System.out.println("Success");
        Assert.assertEquals(255, findRank("SECRET"));
        System.out.println("Success");
    }

    public static int findRank(String A) {
        int n = A.length();
        char[] chars = A.toCharArray();
        byte[] ascii = new byte[256];

        //calculate factorials uptil n
        BigInteger[] factors = new BigInteger[n + 1];
        factors[0] = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            factors[i] = factors[i - 1].multiply(new BigInteger(String.valueOf(i)));
        }
        factors[0] = BigInteger.ZERO;

        //calculate rank
        BigInteger rank = BigInteger.ONE;
        BigInteger denominator, numerator;
        BigInteger MOD = new BigInteger(String.valueOf(1000003));
        for (int i = 0; i < n; i++) {
            long count = 0;
            Arrays.fill(ascii, (byte) 0); // clear
            ascii[chars[i]]++;
            //calculate no of character smaller than chars[i]
            for (int j = i + 1; j < n; j++) {
                if (chars[j] < chars[i]) {
                    count++;
                }
                ascii[chars[j]]++;
            }
            numerator = factors[n - i - 1].multiply(new BigInteger(String.valueOf(count)));

            denominator = BigInteger.ONE;
            for (int j = 0; j < 256; j++) {
                if (ascii[j] > 0) {
                    denominator = denominator.multiply(factors[ascii[j]]);
                }
            }

            rank = rank.add(numerator.divide(denominator));
            rank = rank.mod(MOD);
        }
        return Integer.parseInt(rank.toString());
    }

}
