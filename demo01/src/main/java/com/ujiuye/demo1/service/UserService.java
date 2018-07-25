package com.ujiuye.demo1.service;

import com.ujiuye.demo1.pojo.Person;

import java.util.List;

public interface UserService {
    List<Person> getAll();

    void add(Person person);
}
