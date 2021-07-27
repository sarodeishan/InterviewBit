package binarysearch.sortModification;

import org.junit.Assert;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

//https://www.interviewbit.com/old/problems/median-of-array/
public class MedianOfArray {


    public static void main(String[] args) {
        Assert.assertEquals(3, findMedianSortedArrays(Arrays.asList(1, 4, 5), Arrays.asList(2, 3)), 0.1);
        System.out.println("Success");
        Assert.assertEquals(2.5, findMedianSortedArrays(Arrays.asList(1, 3), Arrays.asList(2, 4)), 0.1);
        System.out.println("Success");
        Assert.assertEquals(11.5, findMedianSortedArrays(Arrays.asList(0, 23), Arrays.asList()), 0.1);
        System.out.println("Success");

    }

    public static double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
        /*int length = a.size() + b.size();
        int medianIndex;
        boolean takeTwo = false;
        if (length % 2 == 0) {
            takeTwo = true;
            medianIndex = (length / 2) - 1;
        } else {
            medianIndex = length / 2;
        }
        double median = 0;
        int i = 0, first = 0, second = 0;
        for (; i <= medianIndex; i++) {
            int number;
            if (first < a.size() && second < b.size()) {
                if (a.get(first) < b.get(second)) {
                    number = a.get(first);
                    first++;
                } else if (a.get(first) > b.get(second)) {
                    number = b.get(second);
                    second++;
                } else {
                    number = a.get(first);
                    first++;
                }
            } else if (first < a.size()) {
                number = a.get(first);
                first++;
            } else {
                number = b.get(second);
                second++;
            }
            if (i == medianIndex) {
                median += number;
                if (length%2==0 && !takeTwo){
                    median /=2;
                }
                if (takeTwo) {
                    takeTwo = false;
                    i--;
                }
            }
        }
        return median;*/

        PriorityQueue<ArrayIndex> heap = new PriorityQueue<>(Comparator.comparingInt(ArrayIndex::getValue));
        if (!a.isEmpty()) {
            heap.offer(new ArrayIndex(0, a));
        }
        if (!b.isEmpty()) {
            heap.offer(new ArrayIndex(0, b));
        }
        int medianIndex;
        double median = 0;
        int length = a.size() + b.size();
        if (length % 2 == 0) {
            medianIndex = (length / 2) - 1;
        } else {
            medianIndex = length / 2;
        }
        for (int i = 0; i <= medianIndex; i++) {
            ArrayIndex list = heap.poll();
            if (i == medianIndex) {
                median = list.getValue();
            }
            list.increamentIndex();
            if (!list.reachedSize()) {
                heap.offer(list);
            }
        }
        if (length % 2 == 0) {
            ArrayIndex list = heap.poll();
            median += list.getValue();
            median = median / 2;
        }
        return median;
    }

    static class ArrayIndex {
        public int index;
        public final List<Integer> list;

        public ArrayIndex(int index, List<Integer> list) {
            this.index = index;
            this.list = list;
        }

        public void increamentIndex() {
            this.index++;
        }

        public boolean reachedSize() {
            return this.index == this.list.size();
        }

        public int getValue() {
            return this.list.get(this.index);
        }
    }

}
