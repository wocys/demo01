package com.ujiuye.demo1.dao;

import com.ujiuye.demo1.pojo.Bar;
import com.ujiuye.demo1.pojo.ResultBean;

import java.util.List;

public interface BarMapper {
    int deleteByPrimaryKey(Integer bar_id);

    int insert(Bar record);

    int insertSelective(Bar record);

    Bar selectByPrimaryKey(Integer bar_id);

    int updateByPrimaryKeySelective(Bar record);

    int updateByPrimaryKey(Bar record);

    List<ResultBean> getAll();
}