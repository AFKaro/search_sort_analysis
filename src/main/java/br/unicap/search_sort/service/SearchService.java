package br.unicap.search_sort.service;

import br.unicap.search_sort.entity.Configuration;
import br.unicap.search_sort.entity.Organization;
import br.unicap.search_sort.entity.ResponseSearchSort;
import br.unicap.search_sort.entity.User;
import br.unicap.search_sort.functions.search.SearchAlgorithms;
import br.unicap.search_sort.util.ArrayUtil;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;


public class SearchService {

    private final String SEARCH = "Search";
    private final SearchAlgorithms<User> searchAlgorithms;
    private ExecutorService executorService;

    public SearchService(){
        this.searchAlgorithms = new SearchAlgorithms<>();
    }

    public ResponseSearchSort searchUser(Organization organization, Configuration configuration, User user) {

        try{
            return Objects.isNull(configuration.getNumberThreads()) ? searchUserNotThread(organization, configuration, user) :
                    searchUserThread(organization, configuration, user);

        } catch (InterruptedException e) {
            throw new RuntimeException("Erro ao buscar dados. " + e.getMessage());
        }

    }

    public ResponseSearchSort searchUserNotThread(Organization org, Configuration configuration, User user) throws InterruptedException {
        long start;

        start = System.nanoTime();
        User userFound = searchAlgorithms.search(user, org.getUserList(), configuration.getAlgorithmEnum());

        Double timeExecution = (System.nanoTime() - start) / 1e6;
        String status = userFound != null ? "User Found" : "User Not Found";

        return new ResponseSearchSort(SEARCH, configuration.getAlgorithmEnum(), org.getUserList().length, timeExecution, null, status);
    }


    public ResponseSearchSort searchUserThread(Organization org, Configuration configuration, User user) throws InterruptedException {
        final User[] userFound = {null};
        long start;

        List<User[]> parts = ArrayUtil.chopped(org.getUserList(),org.getUserList().length / configuration.getNumberThreads());

        ThreadGroup threadGroup = new ThreadGroup("Group Thread");

        start = System.nanoTime();
        executorService = Executors.newFixedThreadPool(configuration.getNumberThreads());

        IntStream.range(0, configuration.getNumberThreads()).forEach(i ->
                executorService.execute(new Thread(threadGroup, () -> {

                    User u = searchAlgorithms.search(user, parts.get(i), configuration.getAlgorithmEnum());

                    if (!Objects.isNull(u)) {
                        userFound[0] = u;
                        threadGroup.interrupt();

                    }

                }))
        );
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.HOURS);

        Double timeExecution = (System.nanoTime() - start) / 1e6;
        String status = userFound[0] != null ? "User Found" : "User Not Found";

        return new ResponseSearchSort(SEARCH, configuration.getAlgorithmEnum(), org.getUserList().length, timeExecution,
                configuration.getNumberThreads(), status);
    }

}
