package br.unicap.search_sort.functions.sort;

public class BubbleSort<T extends Comparable<T>> {

    public T[] sort(T[] arr) {
        boolean swapped;
        T temp = arr[0];

        do {
            swapped = false;

            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i].compareTo(arr[i + 1]) > 0) {
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    swapped = true;
                }
            }
        } while (swapped);
        return arr;
    }

}