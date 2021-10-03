package br.unicap.search_sort.entity;

import br.unicap.search_sort.entity.enums.AlgorithmEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseSearchSort {

    private String task;
    private AlgorithmEnum algorithm;
    private int vectorSize;
    private Double timeExecution;
    private Integer numberThreads;
    private String status;

}
