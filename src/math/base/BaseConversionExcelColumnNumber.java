package math.base;

import org.junit.Assert;

import java.util.ArrayList;

//https://www.interviewbit.com/problems/excel-column-number/
public class BaseConversionExcelColumnNumber {

    public static void main(String[] args) {
        Assert.assertEquals(28, titleToNumber("AB"));
        System.out.println("Success");
        Assert.assertEquals(1, titleToNumber("A"));
        System.out.println("Success");
    }

    public static int titleToNumber(String A) {
        int result = 0;
        int power = 0;
        for (int i = A.length() - 1; i >= 0; i--) {
            int number = (int) A.charAt(i) - 64;
            result += number * Math.pow(26, power);
            power++;
        }
        return result;
    }
}
