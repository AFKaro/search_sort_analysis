package br.unicap.search_sort;


import br.unicap.search_sort.controller.OrganizationController;
import br.unicap.search_sort.entity.Organization;
import br.unicap.search_sort.entity.ResponseGenerate;
import br.unicap.search_sort.entity.ResponseSearchSort;
import br.unicap.search_sort.entity.User;
import br.unicap.search_sort.test.GenerateOrganizationTest;
import br.unicap.search_sort.test.SearchTest;
import br.unicap.search_sort.test.SortTest;
import br.unicap.search_sort.util.CsvUtil;
import br.unicap.search_sort.util.PrinterUtil;
import lombok.extern.java.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Log
public class SearchSortApplication{

    public static void main(String[] args) throws Exception {
        List<Double> vectorSizes = new ArrayList(Arrays.asList(1e3, 1e4, 1e5, 1e6, 1e7));

        List<ResponseSearchSort> responsesSearch = new ArrayList<>(), responsesSort = new ArrayList<>();
        List<ResponseGenerate> responsesGenerate = new ArrayList<>();
        OrganizationController organizationController = new OrganizationController();

        for(Double size: vectorSizes) {
            PrinterUtil.print("== Vector Size: " + size.intValue() +" ==");
            // GENERATE ORG
            responsesGenerate.addAll(GenerateOrganizationTest.genecreateOrganization(size.intValue()));
            Organization org = responsesGenerate.get(responsesGenerate.size() - 1).getOrganization();

            User user = organizationController.getRandomUser(org);

            // LINEAR SEARCH
            responsesSearch.addAll(SearchTest.runLinearSearchTest(org, user));

            // SORT ALGORITHMS
            responsesSort.addAll(SortTest.runSortTest(org));

            // BINARY SEARCH
            responsesSearch.addAll(SearchTest.runBinarySearchTest(org, user));
        }

        // Export Results
        CsvUtil.exportResponses("search_results", responsesSearch);
        CsvUtil.exportResponses("sort_results", responsesSort);
        CsvUtil.exportResponsesGenerate("generate_org_results", responsesGenerate);

    }

}