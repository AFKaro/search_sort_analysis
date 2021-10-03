package br.unicap.search_sort.test;

import br.unicap.search_sort.controller.SortController;
import br.unicap.search_sort.entity.Organization;
import br.unicap.search_sort.entity.ResponseSearchSort;
import br.unicap.search_sort.entity.enums.AlgorithmEnum;
import br.unicap.search_sort.util.PrinterUtil;

import java.util.ArrayList;
import java.util.List;


public class SortTest {

    private static final SortController sortController = new SortController();

    public static List<ResponseSearchSort> runSortTest(Organization org){
        List<ResponseSearchSort> responses = new ArrayList<>();
        Organization org2 = new Organization("SSA Organization 2", org.getUserList());

        runSort(responses, org, AlgorithmEnum.QUICK_SORT);
        runSort(responses, org2, AlgorithmEnum.BUBBLE_SORT);

        return responses;
    }


    public static void runSort(List<ResponseSearchSort> responses, Organization org, AlgorithmEnum sortAlgorithmEnum){
        ResponseSearchSort response;

        PrinterUtil.print("Sort Algorithm - "+ sortAlgorithmEnum.name().toUpperCase());

        PrinterUtil.print("Thread: " + null);
        response = sortController.sortUsers(org, false, sortAlgorithmEnum);
        responses.add(response);

        PrinterUtil.print("Thread: " + 7);
        response = sortController.sortUsers(org, true, sortAlgorithmEnum);
        responses.add(response);
    }

}
