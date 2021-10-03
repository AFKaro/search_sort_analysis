package br.unicap.search_sort.test;

import br.unicap.search_sort.controller.OrganizationController;
import br.unicap.search_sort.entity.Organization;
import br.unicap.search_sort.entity.ResponseGenerate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenerateOrganizationTest {

    private static OrganizationController organizationController = new OrganizationController();

    public static List<ResponseGenerate> genecreateOrganization(Integer size){
        return new ArrayList<>(Arrays.asList(
                organizationController.createOrganization("SSA Organization", size, false),
                organizationController.createOrganization("SSA Organization", size, true)
        ));
    }


}
