package br.unicap.search_sort.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;


@Data
@AllArgsConstructor
public class User implements Comparable<User> {

    private UUID id;
    private String name;

    @Override
    public int compareTo(User o) {
        return this.getId().compareTo(o.getId());
    }
}
