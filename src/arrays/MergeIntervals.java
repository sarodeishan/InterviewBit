package arrays;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://www.interviewbit.com/problems/merge-intervals/
public class MergeIntervals {

    public static void main(String[] args) {
        ArrayList<Interval> A = new ArrayList<>();
        A.add(new Interval(1, 3));
        A.add(new Interval(6, 9));
        ArrayList<Interval> result = insert(A, new Interval(2, 5));
        System.out.println(result);
        Assert.assertEquals("[[1,5], [6,9]]", result.toString());
        System.out.println("Success");

        A = new ArrayList<>();
        A.add(new Interval(1, 2));
        A.add(new Interval(3, 5));
        A.add(new Interval(6, 7));
        A.add(new Interval(8, 10));
        A.add(new Interval(12, 16));
        result = insert(A, new Interval(4, 9));
        System.out.println(result);
        Assert.assertEquals("[[1,2], [3,10], [12,16]]", result.toString());
        System.out.println("Success");

        A = new ArrayList<>();
        A.add(new Interval(1, 2));
        A.add(new Interval(3, 6));
        result = insert(A, new Interval(10, 8));
        System.out.println(result);
        Assert.assertEquals("[[1,2], [3,6], [8,10]]", result.toString());
        System.out.println("Success");

        A = new ArrayList<>();
        A.add(new Interval(1, 2));
        A.add(new Interval(5, 6));
        result = insert(A, new Interval(3, 4));
        System.out.println(result);
        Assert.assertEquals("[[1,2], [3,4], [5,6]]", result.toString());
        System.out.println("Success");

    }

    static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }

        @Override
        public String toString() {
            return "[" + start + "," + end + ']';
        }
    }

    public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> result = new ArrayList<>();
        if (newInterval.end < newInterval.start) {
            newInterval = new Interval(newInterval.end, newInterval.start);
        }
        if (intervals.isEmpty()) {
            result.add(newInterval);
            return result;
        }
        intervals.add(newInterval);
        intervals.sort((o1, o2) -> Integer.valueOf(o1.start).compareTo(o2.start));
        result.add(intervals.get(0));
        for (int i = 1; i < intervals.size(); i++) {
            Interval previous = result.get(result.size() - 1);
            Interval next = intervals.get(i);
            if (previous.end >= next.start) {
                result.remove(result.size() - 1);
                result.add(new Interval(Math.min(previous.start, next.start), Math.max(previous.end, next.end)));
            } else {
                result.add(next);
            }
        }
        return result;
    }

}
