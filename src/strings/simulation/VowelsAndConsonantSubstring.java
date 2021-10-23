package strings.simulation;

import org.junit.Assert;

public class VowelsAndConsonantSubstring {


    public static void main(String[] args) {
        Assert.assertEquals(2, solve("aba"));
        System.out.println("Success");
        Assert.assertEquals(0, solve("a"));
        System.out.println("Success");
    }

    public static int solve(String A) {
        long count = 0;
        long[] suffixArray = new long[A.length()];
        long vowelCount = 0;
        long consonantCount = 0;
        for (int i = A.length()-1; i >= 0; i--) {
            if (isVowel(A.charAt(i))){
                suffixArray[i] = consonantCount;
                vowelCount++;
            } else {
                suffixArray[i] = vowelCount;
                consonantCount++;
            }
        }
        for (int i = 0; i < A.length(); i++) {
            count = count + suffixArray[i];
        }
        return (int)(count % 1000000007);
    }
    /*
    public static int solve(String A) {
        long count = 0;
        for (int start = 0; start < A.length()-1; start++) {
            boolean isStartVowel = isVowel(A.charAt(start));
            for (int end = start + 1; end < A.length(); end++) {
                boolean isEndVowel = isVowel(A.charAt(end));
                if (isStartVowel ^ isEndVowel){
                    count++;
                }
            }
        }
        return (int)(count % 1000000007);
    }*/

    public static boolean isVowel(char c){
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' ||c == 'u'){
            return true;
        }
        return false;
    }

}
