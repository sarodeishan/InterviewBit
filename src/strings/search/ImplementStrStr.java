package strings.search;

import org.junit.Assert;

//https://www.interviewbit.com/old/problems/implement-strstr/
public class ImplementStrStr {


    public static void main(String[] args) {
        Assert.assertEquals(0, strStr("ABEC", "AB"));
        System.out.println("Success");
        Assert.assertEquals(2, strStr("ABEC", "E"));
        System.out.println("Success");
        Assert.assertEquals(-1, strStr("ABEC", "DE"));
        System.out.println("Success");
        Assert.assertEquals(-1, strStr("ABEC", ""));
        System.out.println("Success");
        Assert.assertEquals(-1, strStr("", ""));
        System.out.println("Success");
        Assert.assertEquals(-1, strStr("ABEC", null));
        System.out.println("Success");
        Assert.assertEquals(-1, strStr(null, null));
        System.out.println("Success");
        Assert.assertEquals(-1, strStr("bbbbbbbbab", "baba"));
        System.out.println("Success");
        Assert.assertEquals(48, strStr("bbaabbbbbaabbaabbbbbbabbbabaabbbabbabbbbababbbabbabaaababbbaabaaaba", "babaaa"));
        System.out.println("Success");
    }

    public static int strStr(final String A, final String B) {
        if (A == null || B == null || A.isEmpty() || B.isEmpty()) {
            return -1;
        }
        int result = -1;//not found
        for (int i = 0; i <= A.length() - B.length(); i++) {
            boolean found = true;
            int startIndex = i;
            int endIndex = i;
            for (int j = 0; j < B.length(); j++) {
                if (B.charAt(j) == A.charAt(endIndex)) {
                    endIndex++;
                } else {
                    found = false;
                    break;
                }
            }
            if (found) {
                result = startIndex;
                break;
            }
        }
        return result;
    }

}
