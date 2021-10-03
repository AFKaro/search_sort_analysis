package br.unicap.search_sort.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Organization {

    private String name;
    private User[] userList;

}
