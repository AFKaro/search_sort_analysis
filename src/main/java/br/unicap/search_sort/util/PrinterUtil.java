package br.unicap.search_sort.util;

import br.unicap.search_sort.entity.ResponseSearchSort;
import br.unicap.search_sort.entity.User;

public class PrinterUtil {

    public static void print(String message){
        System.out.println(message);
    }

    public static void print(User user){
        System.out.println("User: " + user.toString());
    }

    public static void print(ResponseSearchSort response){

        System.out.println("--------------------------\n"+
                "Threads: " + response.getNumberThreads() + "\n"+
                "Time: " + response.getTimeExecution() + " ms\n"+
                response.getStatus());
    }
}
