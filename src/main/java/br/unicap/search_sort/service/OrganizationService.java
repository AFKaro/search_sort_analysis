package br.unicap.search_sort.service;

import br.unicap.search_sort.entity.Organization;
import br.unicap.search_sort.entity.ResponseGenerate;
import br.unicap.search_sort.entity.User;
import br.unicap.search_sort.util.DataUtil;
import br.unicap.search_sort.util.PrinterUtil;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class OrganizationService {

    private ExecutorService executorService;

    public ResponseGenerate createOrganization(String name, Integer numberUsers, boolean parallel) throws InterruptedException {
        PrinterUtil.print("Creating and populating organization " + (parallel?"with parallel..." : "..."));
        List<User> users;
        long start;

        executorService = Executors.newSingleThreadExecutor();
        start = System.nanoTime();
        if(parallel) {
            users = IntStream.range(0, numberUsers)
                    .parallel()
                    .mapToObj(i -> new User(DataUtil.generateUUID(), DataUtil.generateName()))
                    .collect(Collectors.toList());
        }else{
            users = IntStream.range(0, numberUsers)
                    .mapToObj(i -> new User(DataUtil.generateUUID(), DataUtil.generateName()))
                    .collect(Collectors.toList());
        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.HOURS);

        Double timeExecution = (System.nanoTime() - start) / 1e6;

        User[] usersArray = new User[users.size()];
        users.toArray(usersArray);

        return new ResponseGenerate("Generate Organization", timeExecution, numberUsers, parallel, new Organization(name, usersArray));
    }


    public User getRandomUser(Organization org){
        int index = (int) Math.random();
        while(org.getUserList().length < index) index = (int) Math.random();
        return org.getUserList()[index];
    }

}
