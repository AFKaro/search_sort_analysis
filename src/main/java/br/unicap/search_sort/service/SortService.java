package br.unicap.search_sort.service;

import br.unicap.search_sort.entity.Organization;
import br.unicap.search_sort.entity.ResponseSearchSort;
import br.unicap.search_sort.entity.User;
import br.unicap.search_sort.entity.enums.AlgorithmEnum;
import br.unicap.search_sort.functions.sort.BubbleSort;
import br.unicap.search_sort.functions.sort.BubbleSortMutliThreading;
import br.unicap.search_sort.functions.sort.QuickSort;
import br.unicap.search_sort.functions.sort.QuickSortMutliThreading;
import br.unicap.search_sort.util.ArrayUtil;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;


public class SortService {

    private static final String SORT = "sort";


    public ResponseSearchSort sortUsers(boolean thread, Organization org, AlgorithmEnum algorithmEnum) {

        try{
            Integer numThreads;
            long start;

            ExecutorService executorService = Executors.newSingleThreadExecutor();
            start = System.nanoTime();

            if(thread) {
                numThreads = sortUsersThread(org.getUserList(), algorithmEnum);
            } else{
                numThreads = sortUsersNotThread(org.getUserList(), algorithmEnum);
            }

            executorService.shutdown();
            executorService.awaitTermination(1, TimeUnit.HOURS);

            Double timeExecution = (System.nanoTime() - start) / 1e6;
            String status = ArrayUtil.verifyData(org.getUserList()) ? "Ordered Users" : "Unordered Users";

            return new ResponseSearchSort(SORT, algorithmEnum, org.getUserList().length, timeExecution, numThreads, status);

        } catch (InterruptedException e) {
            throw new RuntimeException("Erro ao buscar dados. " + e.getMessage());
        }

    }


    public Integer sortUsersNotThread(User[] users, AlgorithmEnum algorithmEnum) throws InterruptedException {

        if(algorithmEnum.equals(AlgorithmEnum.QUICK_SORT)) {
            QuickSort<User> quickSort = new QuickSort<>();
           quickSort.sort(users);
        }else {
            BubbleSort<User> bubbleSort = new BubbleSort<>();
            bubbleSort.sort(users);
        }

        return null;
    }


    public Integer sortUsersThread(User[] users, AlgorithmEnum algorithmEnum) throws InterruptedException {
        ForkJoinPool pool = ForkJoinPool.commonPool();

        pool.invoke(algorithmEnum.equals(AlgorithmEnum.QUICK_SORT) ?
                new QuickSortMutliThreading(0, users.length - 1, users) :
                new BubbleSortMutliThreading<>(users));

        return pool.getParallelism();
    }

}
