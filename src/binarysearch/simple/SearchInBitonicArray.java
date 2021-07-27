package binarysearch.simple;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import org.junit.Assert;

import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

//https://www.interviewbit.com/problems/search-in-bitonic-array/
public class SearchInBitonicArray {


    public static void main(String[] args) {

        Assert.assertEquals(-1, solve(Arrays.asList(5, 6, 7, 8, 9, 10, 3, 2, 1), 30));
        System.out.println("Success");

        Assert.assertEquals(3, solve(Arrays.asList(3, 9, 10, 20, 17, 5, 1), 20));
        System.out.println("Success");

        Assert.assertEquals(18, solve(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11), 12));
        System.out.println("Success");

    }

    public static int solve(List<Integer> A, int B) {
        int low1 = 0, high1 = -1, low2 = -1, high2 = A.size() - 1;
        for (int i = 0; i < A.size() - 1; i++) {
            if (A.get(i) > A.get(i + 1)) {
                high1 = i;
                break;
            }
        }
        low2 = high1 + 1;
        while (low1 <= high1) {
            int mid = low1 + (high1-low1) / 2;
            if (A.get(mid) == B) {
                return mid;
            } else if (A.get(mid) < B) {
                low1 = mid+1;
            } else {
                high1 = mid-1;
            }
        }
        while (low2 <= high2) {
            int mid = low2 + (high2-low2) / 2;
            if (A.get(mid) == B) {
                return mid;
            } else if (A.get(mid) < B) {
                high2 = mid-1;
            } else {
                low2 = mid+1;
            }
        }
        return -1;
    }
}
