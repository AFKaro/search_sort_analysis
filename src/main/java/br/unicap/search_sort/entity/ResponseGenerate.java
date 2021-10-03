package br.unicap.search_sort.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseGenerate {

    private String task;
    private Double timeExecution;
    private int vectorSize;
    private Boolean parallel;
    private Organization organization;

}
