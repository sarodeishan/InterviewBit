package strings.simulation;

import org.junit.Assert;

//https://www.interviewbit.com/old/problems/count-and-say/
public class CountAndSay {


    public static void main(String[] args) {
        Assert.assertEquals("1", countAndSay(1));
        System.out.println("Success");
        Assert.assertEquals("11", countAndSay(2));
        System.out.println("Success");
        Assert.assertEquals("21", countAndSay(3));
        System.out.println("Success");
        Assert.assertEquals("1211", countAndSay(4));
        System.out.println("Success");
    }

    public static String countAndSay(int A) {
        String previousResult = "1";
        if (A == 1) {
            return previousResult;
        }
        StringBuilder iThResult = new StringBuilder();
        for (int i = 2; i <= A; i++) {
            iThResult.delete(0, iThResult.length());
            for (int j = 0; j < previousResult.length(); j++) {
                char iterationCharacter = previousResult.charAt(j);
                int count = 1;
                for (int k = j + 1; k < previousResult.length() && (iterationCharacter == previousResult.charAt(k)); k++) {
                    count++;
                    j++;
                }
                iThResult.append(count).append(iterationCharacter);
            }
            previousResult = iThResult.toString();
        }
        return iThResult.toString();
    }

}
