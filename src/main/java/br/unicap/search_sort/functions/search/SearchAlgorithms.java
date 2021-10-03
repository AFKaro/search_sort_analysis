package br.unicap.search_sort.functions.search;

import br.unicap.search_sort.entity.enums.AlgorithmEnum;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SearchAlgorithms<T extends Comparable<T>> {

    public T search(T obj, T[] list, AlgorithmEnum algorithm){
        switch (algorithm){
            case LINEAR_SEARCH:
                return sequentialSearch(obj, list);
            case BINARY_SEARCH:
                return binarySearch(obj, list);
        }
        return null;
    }

    private T sequentialSearch(T obj, T[] list) {
        List<T> found = Arrays.stream(list)
                .filter(e -> e.compareTo(obj) == 0)
                .collect(Collectors.toList());

        return found.size() > 0 ? found.get(0) : null;
    }


    private T binarySearch(T obj, T[] list) {

        int start = 0;
        int middle;
        int end = list.length - 1;

        while(start <= end) {
            middle = (end + start) / 2;

            if(list[middle].compareTo(obj) == 0) {
                return list[middle];
            }

            if(list[middle].compareTo(obj) < 0) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }

        return null;
    }
}
