package com.ujiuye.demo1.service.impl;

import com.ujiuye.demo1.dao.BarMapper;
import com.ujiuye.demo1.pojo.ResultBean;
import com.ujiuye.demo1.service.BarService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BarServiceImpl implements BarService {
    @Resource
    BarMapper barMapper;

    @Override
    public List<ResultBean> getAll() {
        return barMapper.getAll();
    }
}
