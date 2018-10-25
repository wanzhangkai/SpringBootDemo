package com.pipikai.dao;

import com.pipikai.pojo.TestObject;

public interface TestObjectMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TestObject record);

    int insertSelective(TestObject record);

    TestObject selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TestObject record);

    int updateByPrimaryKey(TestObject record);
}