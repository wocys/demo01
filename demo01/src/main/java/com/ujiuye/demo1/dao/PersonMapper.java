package com.ujiuye.demo1.dao;

import com.ujiuye.demo1.pojo.Person;

import java.util.List;

public interface PersonMapper {
    int deleteByPrimaryKey(Integer person_id);

    int insert(Person record);

    int insertSelective(Person record);

    Person selectByPrimaryKey(Integer person_id);

    int updateByPrimaryKeySelective(Person record);

    int updateByPrimaryKey(Person record);

    List<Person> getAll();
}