package br.unicap.search_sort.test;

import br.unicap.search_sort.controller.SearchController;
import br.unicap.search_sort.entity.Configuration;
import br.unicap.search_sort.entity.Organization;
import br.unicap.search_sort.entity.ResponseSearchSort;
import br.unicap.search_sort.entity.User;
import br.unicap.search_sort.entity.enums.AlgorithmEnum;
import br.unicap.search_sort.util.PrinterUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchTest {

    private static final SearchController searchController = new SearchController();
    private static final List<Integer> fibonacci = (Arrays.asList(2, 3, 5, 8));


    public static List<ResponseSearchSort> runLinearSearchTest(Organization org, User user){
        Configuration config = new Configuration(null, AlgorithmEnum.LINEAR_SEARCH);
        List<ResponseSearchSort> responses = new ArrayList<>();

        PrinterUtil.print("Search Algorithm - LINEAR SEARCH");

        search(responses, org, config, user);

        for(Integer i: fibonacci){
            config.setNumberThreads(i);
            search(responses, org, config, user);
        }

        return responses;
    }


    public static List<ResponseSearchSort> runBinarySearchTest(Organization org, User user){
        Configuration config = new Configuration(null, AlgorithmEnum.BINARY_SEARCH);
        List<ResponseSearchSort> responses = new ArrayList<>();

        PrinterUtil.print("Search Algorithm - BINARY SEARCH");
        PrinterUtil.print("Thread: "+null);
        search(responses, org, config, user);

        for(Integer i: fibonacci){
            config.setNumberThreads(i);
            PrinterUtil.print("Thread: "+i);
            search(responses, org, config, user);
        }

        return responses;
    }


    private static void search(List<ResponseSearchSort> responses, Organization org, Configuration config, User user){
        ResponseSearchSort response = searchController.searchUser(org, config, user);
        responses.add(response);
    }

}
