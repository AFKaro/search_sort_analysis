package br.unicap.search_sort.controller;

import br.unicap.search_sort.entity.Organization;
import br.unicap.search_sort.entity.ResponseGenerate;
import br.unicap.search_sort.entity.User;
import br.unicap.search_sort.service.OrganizationService;
import lombok.AllArgsConstructor;


@AllArgsConstructor
public class OrganizationController {

    OrganizationService service;

    public OrganizationController(){
        this.service = new OrganizationService();
    }

    public ResponseGenerate createOrganization(String name, Integer numberUsers, boolean parallel){

        try {
            return service.createOrganization(name, numberUsers, parallel);
        }catch(Exception e){
            throw new RuntimeException("Erro ao gerar Organização. " + e.getMessage());
        }
    }

    public User getRandomUser(Organization org){

        try {
            return service.getRandomUser(org);
        }catch(Exception e){
            throw new RuntimeException("Erro ao selecionar Usuário Aleatório. " + e.getMessage());
        }
    }
}
