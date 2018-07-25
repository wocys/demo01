package com.ujiuye.demo1.controller;

import com.ujiuye.demo1.pojo.Person;
import com.ujiuye.demo1.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("hello")
public class Hello {

    @Resource
    PersonService service;

    @RequestMapping("getAllPerson")
    @ResponseBody
    public List<Person> getAllPerson(){
        return service.getAllPerson();
    }
}
