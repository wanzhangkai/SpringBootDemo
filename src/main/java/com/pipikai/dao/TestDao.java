package com.pipikai.dao;

import com.pipikai.domain.TestObject;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

public interface TestDao {

    TestObject getTestObject(Integer id);



}
