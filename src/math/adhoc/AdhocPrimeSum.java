package math.adhoc;

import org.junit.Assert;

import java.util.ArrayList;

//https://www.interviewbit.com/old/problems/prime-sum/
public class AdhocPrimeSum {

    public static void main(String[] args) {
        System.out.println(primesum(4));
        System.out.println("Success");
        System.out.println(primesum(6));
        System.out.println("Success");
        System.out.println(primesum(100));
        System.out.println("Success");
    }

    public static ArrayList<Integer> primesum(int A) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 2; i < A; i++) {
            if (isPrime(i) && isPrime(A - i)) {
                result.add(i);
                result.add(A - i);
                break;
            }
        }
        return result;
    }

    public static boolean isPrime(int number) {
        if (number != 2 && number % 2 == 0) {
            return false;
        }
        for (int i = 2; i <= number / 2; i++) {
            if (i != 2 && i % 2 == 0) {
                continue;
            }
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
