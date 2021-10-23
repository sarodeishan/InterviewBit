package strings.tricks;

import org.junit.Assert;

//https://www.interviewbit.com/problems/minimum-parantheses/
public class MinimumParantheses {

    public static void main(String[] args) {
        Assert.assertEquals(1, solve("())"));
        System.out.println("Success");

        Assert.assertEquals(3, solve("((("));
        System.out.println("Success");

        Assert.assertEquals(2, solve(")("));
        System.out.println("Success");

        Assert.assertEquals(21, solve("))((()()()))())())()))()(())))))(()((((((((()()((())())(((((()(()())((()))))((()()())((())))((()()))()((()((())))))"));
        System.out.println("Success");
    }

    public static int solve(String A) {
        int closeCount = 0;
        int openCount = 0;
        for (int i = 0; i < A.length(); i++) {
            if ('(' == A.charAt(i))
                openCount++;
            else {
                if (openCount == 0) {
                    closeCount++;
                } else {
                    openCount--;
                }
            }

        }
        return openCount + closeCount;
    }
//        int finalCount = 0;
//        int openCount = 0;
//        int i = 0;
//        for (; i < A.length(); i++) {
//            if (openCount == 0) {
//                int closedCount = countUnresolvedCloseParantheses(A, i);
//                i += closedCount;
//                finalCount += closedCount;
//                if (i >= A.length()) {
//                    break;
//                }
//            }
//            if (A.charAt(i) == '(') {
//                openCount++;
//            } else if (A.charAt(i) == ')') {
//                openCount--;
//            }
//        }
//        finalCount += openCount;
//        return finalCount;
//    }
//
//    private static int countUnresolvedCloseParantheses(String A, int index) {
//        int unresolvedClosedCount = 0;
//        for (; index < A.length() && A.charAt(index) == ')'; index++) {
//            unresolvedClosedCount++;
//        }
//        return unresolvedClosedCount;
//    }

}
