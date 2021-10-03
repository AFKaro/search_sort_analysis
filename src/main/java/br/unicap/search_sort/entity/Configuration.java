package br.unicap.search_sort.entity;

import br.unicap.search_sort.entity.enums.AlgorithmEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Configuration {

    private Integer numberThreads;
    private AlgorithmEnum algorithmEnum;
}
