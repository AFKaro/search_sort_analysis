package br.unicap.search_sort.util;

import br.unicap.search_sort.entity.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayUtil {

    public static List<User[]> chopped(User[] array, int L) {
        List<User[]> parts = new ArrayList<>();
        List<User> list = Arrays.asList(array);
        List<User> part;

        int N = list.size();
        for (int i = 0; i < N; i += L) {
            part = list.subList(i, Math.min(N, i + L));
            User[] usersArray = new User[part.size()];
            parts.add(part.toArray(usersArray));
        }

        return parts;
    }

    public static boolean verifyData(User arr[]) {
        int n = arr.length - 1;
        for (int i = 0; i < n; ++i) {
            if (arr[i].compareTo(arr[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }
}
