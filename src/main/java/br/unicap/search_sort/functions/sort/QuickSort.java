package br.unicap.search_sort.functions.sort;

public class QuickSort<T extends Comparable<T>> {

    public T[] sort(T[] arr) {
        quickSort(arr,0,arr.length-1);
        return arr;
    }

    public void quickSort(T[] arr, int start, int end) {
        if (start < end) {
            int pivot = partition(arr, start, end);
            quickSort(arr, start, pivot-1);
            quickSort(arr, pivot+1,end);
        }
    }

    public int partition(T[] arr, int start, int end) {
        T pivot = arr[start];
        int i = start + 1, f = end;
        while (i <= f) {
            if (arr[i].compareTo(pivot) <= 0)
                i++;
            else if (pivot.compareTo(arr[f]) < 0)
                f--;
            else {
                T troca = arr[i];
                arr[i] = arr[f];
                arr[f] = troca;
                i++;
                f--;
            }
        }
        arr[start] = arr[f];
        arr[f] = pivot;
        return f;
    }

}