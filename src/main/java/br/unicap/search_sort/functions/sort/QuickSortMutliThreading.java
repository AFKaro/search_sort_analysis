package br.unicap.search_sort.functions.sort;

import java.util.concurrent.RecursiveTask;

public class QuickSortMutliThreading<T extends Comparable<T>> extends RecursiveTask<Integer> {

    QuickSort quickSort = new QuickSort();
    int start, end;
    T[] arr;

    public QuickSortMutliThreading(int start, int end, T[] arr){
        this.arr = arr;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute(){
        if (start < end) {
            int p = quickSort.partition(arr, start, end);
            QuickSortMutliThreading left = new QuickSortMutliThreading(start,p - 1, arr);
            QuickSortMutliThreading right = new QuickSortMutliThreading(p + 1, end, arr);
        }
        return null;
    }

}