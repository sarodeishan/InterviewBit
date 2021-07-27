package math.adhoc;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://www.interviewbit.com/problems/sum-of-pairwise-hamming-distance/
public class AdhocSumOfPairwiseHammingDistance {

    public static void main(String[] args) {
        System.out.println(hammingDistance(Arrays.asList(1)));
        System.out.println("Success");
        System.out.println(hammingDistance(Arrays.asList(2, 4, 6)));
        System.out.println("Success");
    }

    public static int hammingDistance(final List<Integer> A) {
        long ans=0;
        long n = A.size();
        long count =0;
        for(int i=0;i<31;i++){
            count =0;
            for(int j=0;j<n;j++){
                if((A.get(j)&(1<<i))!=0){
                    count++;
                }
            }
            ans = (ans + count*(n-count)*2)%1000000007;
        }
        return (int)ans;
    }

}
