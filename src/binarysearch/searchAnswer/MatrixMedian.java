package binarysearch.searchAnswer;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//https://www.interviewbit.com/old/problems/matrix-median/
public class MatrixMedian {


    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> rows = new ArrayList<>();
        ArrayList<Integer> row1 = new ArrayList<>();
        row1.add(1);row1.add(3);row1.add(5);
        ArrayList<Integer> row2 = new ArrayList<>();
        row1.add(2);row1.add(6);row1.add(9);
        ArrayList<Integer> row3 = new ArrayList<>();
        row1.add(3);row1.add(6);row1.add(9);
        rows.add(row1);
        rows.add(row2);
        rows.add(row3);
        Assert.assertEquals(5, findMedian(rows));
        System.out.println("Success");
    }

    public static int findMedian(ArrayList<ArrayList<Integer>> A) {
        ArrayList<Integer> list=new ArrayList();
        for(int i=0;i<A.size();i++){
            for(int j=0;j<A.get(i).size();j++){
                list.add(A.get(i).get(j));
            }}
        Collections.sort(list);
        return list.get(list.size()/2);
    }
}
