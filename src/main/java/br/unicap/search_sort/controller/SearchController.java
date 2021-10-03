package br.unicap.search_sort.controller;

import br.unicap.search_sort.entity.Configuration;
import br.unicap.search_sort.entity.Organization;
import br.unicap.search_sort.entity.ResponseSearchSort;
import br.unicap.search_sort.entity.User;
import br.unicap.search_sort.service.SearchService;
import lombok.AllArgsConstructor;


@AllArgsConstructor
public class SearchController {

    private final SearchService service;

    public SearchController() {
        this.service = new SearchService();
    }


    public ResponseSearchSort searchUser(Organization organization, Configuration configuration, User user){
        ResponseSearchSort responseEntity;

        try {
            responseEntity = service.searchUser(organization, configuration, user);
        }catch(Exception e){
            throw new RuntimeException("Erro ao buscar dados. " + e.getMessage());
        }

        return responseEntity;
    }

}
