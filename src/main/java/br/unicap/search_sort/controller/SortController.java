package br.unicap.search_sort.controller;

import br.unicap.search_sort.entity.Organization;
import br.unicap.search_sort.entity.ResponseSearchSort;
import br.unicap.search_sort.entity.enums.AlgorithmEnum;
import br.unicap.search_sort.service.SortService;
import lombok.AllArgsConstructor;



@AllArgsConstructor
public class SortController {

    private final SortService sortService;


    public SortController() {
        this.sortService = new SortService();
    }


    public ResponseSearchSort sortUsers(Organization organization, boolean thread, AlgorithmEnum sortAlgorithmEnum){
        ResponseSearchSort responseEntity;

        try {

            responseEntity = sortService.sortUsers(thread, organization, sortAlgorithmEnum);

        }catch(Exception e){
            throw new RuntimeException("Erro ao ordenar dados. " + e.getMessage());
        }

        return responseEntity;
    }

}
