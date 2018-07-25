package com.ujiuye.demo1.service.impl;

import com.ujiuye.demo1.dao.PersonMapper;
import com.ujiuye.demo1.pojo.Person;
import com.ujiuye.demo1.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    PersonMapper mapper;

    @Override
    public List<Person> getAll() {
        return mapper.getAll();
    }

    @Override
    public void add(Person person) {
        mapper.insertSelective(person);
    }
}
