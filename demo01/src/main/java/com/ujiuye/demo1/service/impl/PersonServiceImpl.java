package com.ujiuye.demo1.service.impl;


import com.ujiuye.demo1.dao.PersonMapper;
import com.ujiuye.demo1.pojo.Person;
import com.ujiuye.demo1.service.PersonService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    @Resource
    PersonMapper personMapper;

    @Override
    public List<Person> getAllPerson() {
        return personMapper.getAll();
    }
}
