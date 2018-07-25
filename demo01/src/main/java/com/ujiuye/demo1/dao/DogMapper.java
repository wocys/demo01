package com.ujiuye.demo1.dao;

import com.ujiuye.demo1.pojo.Dog;

public interface DogMapper {
    int deleteByPrimaryKey(Integer dog_id);

    int insert(Dog record);

    int insertSelective(Dog record);

    Dog selectByPrimaryKey(Integer dog_id);

    int updateByPrimaryKeySelective(Dog record);

    int updateByPrimaryKey(Dog record);
}