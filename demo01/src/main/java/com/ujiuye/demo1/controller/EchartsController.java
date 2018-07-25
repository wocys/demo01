package com.ujiuye.demo1.controller;

import com.ujiuye.demo1.pojo.ResultBean;
import com.ujiuye.demo1.service.BarService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/eCharts")
public class EchartsController {

    @Resource
    BarService service;

    @RequestMapping("/bar")
    @ResponseBody
    public List<ResultBean> bar(){
/*        ResultBean bean1 = new ResultBean();
        ResultBean bean2 = new ResultBean();
        ResultBean bean3 = new ResultBean();
        bean1.setName("beaqn1");
        bean2.setName("bean2");
        bean3.setName("bean3");
        bean1.setValue(100);
        bean2.setValue(200);
        bean3.setValue(300);
        List<ResultBean> list = new ArrayList<>();
        list.addAll(Arrays.asList(bean1,bean2,bean3));*/
        return service.getAll();
    }

    @RequestMapping("/bing")
    @ResponseBody
    public List<ResultBean> bing(){
        System.out.println(service.getAll());
        return service.getAll();
    }

    @RequestMapping("test")
    public String text(){
        return "index";
    }
}
