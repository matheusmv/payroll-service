package com.github.matheusmv.hroauth.entities;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class User {

    private Long id;
    private String name;
    private String email;
    private String password;

    private Set<Role> roles = new HashSet<>();
}
