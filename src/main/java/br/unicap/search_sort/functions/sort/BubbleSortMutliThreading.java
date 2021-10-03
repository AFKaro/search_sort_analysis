package br.unicap.search_sort.functions.sort;

import java.util.concurrent.RecursiveTask;

public class BubbleSortMutliThreading<T extends Comparable<T>> extends RecursiveTask<Integer> {

    BubbleSort<T> bubbleSort = new BubbleSort<>();
    T[] arr;

    public BubbleSortMutliThreading(T[] arr){
        this.arr = arr;
    }

    @Override
    protected Integer compute(){
        bubbleSort.sort(this.arr);
        return null;
    }

}