package br.unicap.search_sort.entity.enums;

public enum AlgorithmEnum {

    LINEAR_SEARCH("Search", "linear search"),
    BINARY_SEARCH("Search", "binary search"),
    QUICK_SORT("Sort", "Quick Sort"),
    BUBBLE_SORT("Sort", "Bubble Sort");

    String type;
    String name;

    AlgorithmEnum(String type, String name){
        this.type = type;
        this.name = name;
    }
}
