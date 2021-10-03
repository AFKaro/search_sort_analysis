package br.unicap.search_sort.util;

import com.github.javafaker.Faker;

import java.util.UUID;

public class DataUtil {

    private static final Faker faker = new Faker();

    public static String generateName(){
        return faker.name().fullName();
    }

    public static UUID generateUUID(){
        return UUID.randomUUID();
    }
}
