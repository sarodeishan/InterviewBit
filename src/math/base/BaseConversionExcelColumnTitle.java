package math.base;

import org.junit.Assert;

//https://www.interviewbit.com/problems/excel-column-title/
public class BaseConversionExcelColumnTitle {

    public static void main(String[] args) {
        Assert.assertEquals("AB", convertToTitle(28));
        System.out.println("Success");
        Assert.assertEquals("A", convertToTitle(1));
        System.out.println("Success");
        Assert.assertEquals("BAQTZ", convertToTitle(943566));
        System.out.println("Success");
    }

    public static String convertToTitle(int A) {
        StringBuilder result = new StringBuilder("");
        while (A > 0) {
            int remainder = A % 26;
            A = A / 26;
            if (remainder == 0) {
                remainder = 26;
                A--;
            }
            result.insert(0, (char) (remainder + 64));
        }
        return result.toString();
    }
}
