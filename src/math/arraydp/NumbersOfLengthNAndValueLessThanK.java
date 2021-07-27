package math.arraydp;

import org.junit.Assert;

import java.util.ArrayList;


//https://www.interviewbit.com/problems/numbers-of-length-n-and-value-less-than-k/
public class NumbersOfLengthNAndValueLessThanK {

    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>();
        input.add(0);
        input.add(1);
        input.add(5);
        Assert.assertEquals(2, solve(input, 1, 2));
        System.out.println("Success");

        input.clear();
        input.add(0);
        input.add(1);
        input.add(2);
        input.add(5);
        Assert.assertEquals(5, solve(input, 2, 21));
        System.out.println("Success");

        input.clear();
        input.add(0);
        input.add(1);
        input.add(2);
        input.add(5);
        Assert.assertEquals(9, solve(input, 2, 51));
        System.out.println("Success");

        input.clear();
        input.add(0);
        input.add(1);
        input.add(2);
        input.add(5);
        Assert.assertEquals(15, solve(input, 3, 154));
        System.out.println("Success");

        input.clear();
        input.add(0);
        input.add(1);
        input.add(2);
        input.add(5);
        Assert.assertEquals(0, solve(input, 5, 154));
        System.out.println("Success");

        input.clear();
        input.add(0);
        input.add(1);
        input.add(2);
        input.add(5);
        Assert.assertEquals(12, solve(input, 2, 154));
        System.out.println("Success");

        input.clear();
        input.add(0);
        input.add(1);
        input.add(2);
        input.add(5);
        Assert.assertEquals(4, solve(input, 1, 123));
        System.out.println("Success");
    }

    public static int solve(ArrayList<Integer> A, int B, int C) {
        if(A.size()==0){
            return 0;
        }
        String limitNum = "" + C;
        int n = limitNum.length();
        //for numbers with only 1 digit, always consider zero
        boolean isSingleDigit = (B==1)||(n==1);
        if (B > n) {
            return 0;
        } else if (B < n) {
            //(number of A's items without zero) * (A.size  to the power of B-1)
            return (int) (fittingNumber(A, 9, isSingleDigit, true) * Math.pow(A.size(), B - 1));
        } else {
            //iterative approach to possibilities
            int result = 0;
            int i = 1;
            boolean firstIteration = true;
            boolean continueIterationForLowerPlaces = true;
            while (i <= B && continueIterationForLowerPlaces) {
                int number = Integer.valueOf(limitNum.substring(i - 1, i)).intValue();
                int fittingNumbers = fittingNumber(A, number, isSingleDigit ? true : !firstIteration, false);
                firstIteration = false;
                result += fittingNumbers * Math.pow(A.size(), B - i);
                if (!A.contains(number)) {
                    continueIterationForLowerPlaces = false;
                }
                i++;
            }
            return result;
        }
    }

    public static int fittingNumber(ArrayList<Integer> A, int input, boolean withZero, boolean equalInput) {
        int count = 0;
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) < input) {
                count++;
            } else if (equalInput && A.get(i) == input) {
                count++;
                break;
            } else {
                break;
            }
        }
        if (!withZero && A.get(0) == 0) {
            if (count != 0)
                count--;
        }
        return count;
    }
}
